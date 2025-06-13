package dev.scastillo.customer.application.service;

import dev.scastillo.customer.domain.model.Customer;
import dev.scastillo.customer.domain.repository.CustomerRepository;
import dev.scastillo.customer.domain.service.CustomerService;
import dev.scastillo.customer.shared.exception.NotFoundException;
import dev.scastillo.customer.shared.util.DateTimeUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setId(UUID.randomUUID());
        customer.setStatus(true);
        customer.setCreateAt(DateTimeUtils.now());
        customer.setUpdateAt(DateTimeUtils.now());
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerRepository.findByUsername(username).orElseThrow(() ->
            new NotFoundException("Customer not found with username: " + username));
    }
}
