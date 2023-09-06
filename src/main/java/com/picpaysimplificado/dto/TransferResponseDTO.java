package com.picpaysimplificado.dto;

import com.picpaysimplificado.entities.Transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferResponseDTO {
    private Long id;
    private BigDecimal amount;
    private Long sourceAccountId;
    private Long targetAccountId;
    private LocalDateTime timestamp;

    public TransferResponseDTO() {
    }

    public TransferResponseDTO(Long id, BigDecimal amount, Long sourceAccountId, Long targetAccountId, LocalDateTime timestamp) {
        this.id = id;
        this.amount = amount;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.timestamp = timestamp;
    }

    public TransferResponseDTO(Transfer entity) {
        id = entity.getId();
        amount = entity.getAmount();
        sourceAccountId = entity.getSourceAccount().getId();
        targetAccountId = entity.getTargetAccount().getId();
        timestamp = entity.getTimestamp();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Long getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(Long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}