package dev.scastillo.customer.domain.repository;

import dev.scastillo.customer.domain.model.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(UUID id);
    Optional<Customer> findByUsername(String username);

}
