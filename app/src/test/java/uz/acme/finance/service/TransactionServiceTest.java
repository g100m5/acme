package uz.acme.finance.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import uz.acme.finance.model.Customer;
import uz.acme.finance.repository.CustomerRepository;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerRepository customerRepository;

    private final List<UUID> createdCustomerIds = new ArrayList<>();

    @AfterEach
    void tearDown() {
        createdCustomerIds.forEach(customerRepository::deleteById);
        createdCustomerIds.clear();
    }

    @BeforeAll
    void setUp() {
        Customer customer = new Customer("John", "Doe", "Middle", BigDecimal.valueOf(1000));
        Customer savedCustomer = customerRepository.save(customer);
        createdCustomerIds.add(savedCustomer.getId());
    }

    @Test
    @DirtiesContext
    public void testConcurrentBalanceUpdates() throws InterruptedException {
        Customer customer = customerRepository.findAll().get(0);
        UUID userId = customer.getId();

        int threadCount = 33;

        BigDecimal amount = BigDecimal.valueOf(100);

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService.execute(() -> {
                try {
                    transactionService.createTransaction(userId, amount);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();

        Customer updatedCustomer = customerRepository.findById(userId).orElseThrow();

        BigDecimal initialBalance = customer.getBalance();
        BigDecimal expectedBalance = initialBalance.add(amount.multiply(BigDecimal.valueOf(threadCount)));

        Assertions.assertEquals(expectedBalance, updatedCustomer.getBalance());
    }
}