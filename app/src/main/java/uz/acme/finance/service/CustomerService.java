package uz.acme.finance.service;

import uz.acme.finance.dto.CustomerDTO;
import uz.acme.finance.mapper.FinanceMapper;
import uz.acme.finance.model.Customer;
import uz.acme.finance.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers() {
        return FinanceMapper.customersToCustomerDTOs(customerRepository.findAll());
    }

    public Optional<CustomerDTO> getCustomerByID(UUID id) {
        return customerRepository.findById(id).map(FinanceMapper::customerToCustomerDTO);
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = FinanceMapper.customerDtoToCustomer(customerDTO);
        return FinanceMapper.customerToCustomerDTO(customerRepository.save(customer));
    }

    public CustomerDTO updateCustomer(UUID id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(user -> {
            user.setFirstName(customerDTO.getFirstName());
            user.setLastName(customerDTO.getLastName());
            user.setPatronym(customerDTO.getPatronym());
            return FinanceMapper.customerToCustomerDTO(customerRepository.save(user));
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
