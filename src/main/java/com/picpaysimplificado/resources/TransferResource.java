package com.picpaysimplificado.resources;

import com.picpaysimplificado.dto.TransferRequestDTO;
import com.picpaysimplificado.dto.TransferResponseDTO;
import com.picpaysimplificado.services.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferResource {

    @Autowired
    private TransferService transferService;

    @PreAuthorize("hasRole('ROLE_COMMON')")
    @PostMapping
    public ResponseEntity<TransferResponseDTO> createTransfer(@Valid @RequestBody TransferRequestDTO request) {
        TransferResponseDTO responseDTO = transferService.transaction(request);
        return ResponseEntity.ok(responseDTO);
    }
}
