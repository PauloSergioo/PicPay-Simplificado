package com.picpaysimplificado.dto;

import com.picpaysimplificado.entities.Transfer;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

public class TransferRequestDTO {

    @DecimalMin(value = "0.1", message = "O valor da transferência deve ser superior a zero")
    private BigDecimal amount;
    private Long sourceAccountId;
    private Long targetAccountId;

    public TransferRequestDTO() {
    }

    public TransferRequestDTO(BigDecimal amount, Long sourceAccountId, Long targetAccountId) {
        this.amount = amount;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
    }

    public TransferRequestDTO(Transfer entity) {
        amount = entity.getAmount();
        sourceAccountId = entity.getSourceAccount().getId();
        targetAccountId = entity.getTargetAccount().getId();
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
}