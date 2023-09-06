package com.picpaysimplificado.resources;

import com.picpaysimplificado.dto.TransferRequestDTO;
import com.picpaysimplificado.dto.TransferResponseDTO;
import com.picpaysimplificado.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<TransferResponseDTO> createTransfer(@RequestBody TransferRequestDTO request) {
        TransferResponseDTO responseDTO = transferService.createTransfer(request);
        return ResponseEntity.ok(responseDTO);
    }
}
