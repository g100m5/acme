package uz.acme.finance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.acme.finance.model.Transaction;
import uz.acme.finance.model.Customer;
import uz.acme.finance.repository.TransactionRepository;
import uz.acme.finance.repository.CustomerRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class AcmeFinanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AcmeFinanceApplication.class, args);
	}
}


