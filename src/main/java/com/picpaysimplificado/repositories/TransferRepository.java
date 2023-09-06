package com.picpaysimplificado.repositories;

import com.picpaysimplificado.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
