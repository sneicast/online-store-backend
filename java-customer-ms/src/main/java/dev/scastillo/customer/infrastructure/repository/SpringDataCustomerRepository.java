package dev.scastillo.customer.infrastructure.repository;

import dev.scastillo.customer.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataCustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByUsername(String username);
}
