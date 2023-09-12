package com.picpaysimplificado.services;

import com.picpaysimplificado.dto.TransferRequestDTO;
import com.picpaysimplificado.dto.TransferResponseDTO;
import com.picpaysimplificado.entities.BankAccount;
import com.picpaysimplificado.entities.Transfer;
import com.picpaysimplificado.entities.User;
import com.picpaysimplificado.repositories.BankAccountRepository;
import com.picpaysimplificado.repositories.TransferRepository;
import com.picpaysimplificado.services.exceptions.InsufficientBalanceException;
import com.picpaysimplificado.services.exceptions.UnauthorizedTransactionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
public class TransferService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private TransferRepository transferRepository;

    private Transfer transfer;

    @Value("${external.authorizer.url}")
    private String externalAuthorizerUrl;

    public TransferResponseDTO transaction(TransferRequestDTO request) {

        BankAccount sourceAccount = bankAccountRepository.findById(request.getSourceAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Source account not found"));

        BigDecimal amount = request.getAmount();
        BigDecimal balance = sourceAccount.getBalance();

        if (balance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient funds in the account");
        }

        boolean isAuthorized = authorizeTransfer(request);

        if (!isAuthorized) {
            rollbackTransaction(transfer.getId());
            throw new UnauthorizedTransactionException("Unauthorized transaction");
        }

        Transfer transfer = new Transfer();
        transfer.setSourceAccount(sourceAccount);

        BankAccount targetAccount = bankAccountRepository.findById(request.getTargetAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Target account not found"));

        transfer.setTargetAccount(targetAccount);
        transfer.setAmount(amount);
        transfer.setTimestamp(LocalDateTime.now());

        transfer = transferRepository.save(transfer);

        return copyDtoToEntity(transfer);
    }

    private boolean authorizeTransfer(TransferRequestDTO request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Map<String, String>> response = restTemplate.exchange(
                externalAuthorizerUrl,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<Map<String, String>>() {}
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, String> responseBody = response.getBody();
            assert responseBody != null;
            String authorizationStatus = responseBody.get("message");

            return "Autorizado".equalsIgnoreCase(authorizationStatus);
        } else {

            return false;
        }
    }

    private TransferResponseDTO copyDtoToEntity(Transfer entity) {
        TransferResponseDTO responseDTO = new TransferResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setAmount(entity.getAmount());
        responseDTO.setSourceAccountId(entity.getSourceAccount().getId());
        responseDTO.setTargetAccountId(entity.getTargetAccount().getId());
        responseDTO.setTimestamp(entity.getTimestamp());
        return responseDTO;
    }

    private void rollbackTransaction(Long transferId) {
        if (transferId == null) {
            return;
        }

        Optional<Transfer> transferOptional = transferRepository.findById(transferId);

        if (transferOptional.isPresent()) {
            Transfer transfer = transferOptional.get();

            transferRepository.delete(transfer);
        }
    }
}