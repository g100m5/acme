package uz.acme.finance.service;

import jakarta.transaction.Transactional;
import uz.acme.finance.dto.TransactionDTO;
import uz.acme.finance.mapper.FinanceMapper;
import uz.acme.finance.model.Customer;
import uz.acme.finance.model.Transaction;
import uz.acme.finance.repository.TransactionRepository;
import uz.acme.finance.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    public TransactionService(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public TransactionDTO createTransaction(UUID userId, BigDecimal amount) {

        Customer customer = customerRepository.findByIdWithLock(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        customer.setBalance(customer.getBalance().add(amount));
        customerRepository.save(customer);

        Transaction transaction = new Transaction(customer, amount, Transaction.TransactionStatus.SUCCESS);
        return FinanceMapper.transactionToTransactionDTO(transactionRepository.save(transaction));
    }

    public List<TransactionDTO> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Transaction> transactions = transactionRepository.findByCreatedDateBetween(startDate, endDate);
        return FinanceMapper.transactionsToTransactionDTOs(transactions);
    }
    public List<TransactionDTO> getAllTransactions() {
        return FinanceMapper.transactionsToTransactionDTOs(transactionRepository.findAll());
    }

    public List<TransactionDTO> getTransactionsByUser(UUID userId) {
        return FinanceMapper.transactionsToTransactionDTOs(transactionRepository.findByCustomerId(userId));
    }
}
