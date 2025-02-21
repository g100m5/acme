package uz.acme.finance.repository;

import uz.acme.finance.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    List<Transaction> findByCustomerId(UUID userId);
    List<Transaction> findByCreatedDateBetween(LocalDateTime timestamp, LocalDateTime timestamp2);
}