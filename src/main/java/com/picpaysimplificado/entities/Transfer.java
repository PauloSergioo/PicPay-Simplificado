package com.picpaysimplificado.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private BankAccount sourceAccount;

    @ManyToOne
    @JoinColumn(name = "target_account_id")
    private BankAccount targetAccount;

    private BigDecimal amount;

    private String status;

    private LocalDateTime timestamp;

    public Transfer() {
    }

    public Transfer(Long id, BankAccount sourceAccount, BankAccount targetAccount, BigDecimal amount, String status, LocalDateTime timestamp) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(BankAccount sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public BankAccount getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(BankAccount targetAccount) {
        this.targetAccount = targetAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transfer transfer)) return false;
        return Objects.equals(id, transfer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}