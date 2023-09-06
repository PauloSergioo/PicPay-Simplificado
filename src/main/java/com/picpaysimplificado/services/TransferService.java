package com.picpaysimplificado.services;

import com.picpaysimplificado.dto.TransferRequestDTO;
import com.picpaysimplificado.dto.TransferResponseDTO;
import com.picpaysimplificado.entities.BankAccount;
import com.picpaysimplificado.entities.Transfer;
import com.picpaysimplificado.repositories.BankAccountRepository;
import com.picpaysimplificado.repositories.TransferRepository;
import com.picpaysimplificado.services.exceptions.UnauthorizedTransactionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransferService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private TransferRepository transferRepository;

    public TransferResponseDTO createTransfer(TransferRequestDTO request) {
        // Recupere a conta de origem com base no ID fornecido
        BankAccount sourceAccount = bankAccountRepository.findById(request.getSourceAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Conta de origem não encontrada"));

        // Verifique se a conta de origem tem saldo suficiente
        if (sourceAccount.getBalance().compareTo(request.getAmount()) < 0) {
            throw new UnauthorizedTransactionException("Saldo insuficiente na conta de origem");
        }

        // Crie uma nova entidade Transfer
        Transfer transfer = new Transfer();
        transfer.setSourceAccount(sourceAccount);
        // Defina a conta de destino com base no ID fornecido em request
        BankAccount targetAccount = bankAccountRepository.findById(request.getTargetAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Conta de destino não encontrada"));
        transfer.setTargetAccount(targetAccount);
        transfer.setAmount(request.getAmount());
        transfer.setTimestamp(LocalDateTime.now());

        // Restante da lógica de transferência
        // ...

        // Salve a entidade Transfer no banco de dados
        transferRepository.save(transfer);

        // Crie e retorne o DTO de resposta
        TransferResponseDTO responseDTO = new TransferResponseDTO();
        responseDTO.setId(transfer.getId());
        responseDTO.setAmount(transfer.getAmount());
        responseDTO.setSourceAccountId(transfer.getSourceAccount().getId());
        responseDTO.setTargetAccountId(transfer.getTargetAccount().getId());
        responseDTO.setTimestamp(transfer.getTimestamp());

        return responseDTO;
    }
}
