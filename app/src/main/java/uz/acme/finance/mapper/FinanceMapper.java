package uz.acme.finance.mapper;

import uz.acme.finance.dto.CustomerDTO;
import uz.acme.finance.dto.TransactionDTO;
import uz.acme.finance.model.Customer;
import uz.acme.finance.model.Transaction;

import java.util.List;

public class FinanceMapper {
    public static CustomerDTO customerToCustomerDTO(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setPatronym(customer.getPatronym());
        customerDTO.setDob(customer.getDob());
        customerDTO.setGenderType(customer.getGenderType());
        customerDTO.setBalance(customer.getBalance());
        return customerDTO;
    }

    public static Customer customerDtoToCustomer(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setPatronym(customerDTO.getPatronym());
        customer.setDob(customerDTO.getDob());
        customer.setGenderType(customerDTO.getGenderType());
        customer.setBalance(customerDTO.getBalance());
        return customer;
    }

    public static TransactionDTO transactionToTransactionDTO(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transaction.getId());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setCreatedDate(transaction.getCreatedDate());
        transactionDTO.setCustomerId(transaction.getCustomer().getId());
        transactionDTO.setTransactionStatus(transaction.getTransactionStatus());
        return transactionDTO;
    }

    public static List<CustomerDTO> customersToCustomerDTOs(List<Customer> customers) {
        if (customers == null || customers.isEmpty()) {
            return null;
        }
        return customers.stream().map(FinanceMapper::customerToCustomerDTO).toList();
    }

    public static List<TransactionDTO> transactionsToTransactionDTOs(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            return null;
        }
        return transactions.stream().map(FinanceMapper::transactionToTransactionDTO).toList();
    }
}