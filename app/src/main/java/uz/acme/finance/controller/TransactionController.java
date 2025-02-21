package uz.acme.finance.controller;

import uz.acme.finance.dto.TransactionDTO;
import uz.acme.finance.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/user/{userId}")
    public List<TransactionDTO> getTransactionsByUser(@PathVariable UUID userId) {
        return transactionService.getTransactionsByUser(userId);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<TransactionDTO> createTransaction(@PathVariable UUID userId, @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(transactionService.createTransaction(userId, amount));
    }

    @GetMapping("/date-range")
    public List<TransactionDTO> getTransactionsByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return transactionService.getTransactionsByDateRange(startDate, endDate);
    }
}
