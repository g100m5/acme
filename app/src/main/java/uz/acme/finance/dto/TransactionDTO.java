package uz.acme.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.acme.finance.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private UUID id;
    private UUID customerId;
    private BigDecimal amount;
    private LocalDateTime createdDate;
    private Transaction.TransactionStatus transactionStatus;
}
