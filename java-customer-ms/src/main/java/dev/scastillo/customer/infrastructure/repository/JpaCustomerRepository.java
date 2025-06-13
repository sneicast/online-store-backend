package dev.scastillo.customer.infrastructure.repository;

import dev.scastillo.customer.domain.model.Customer;
import dev.scastillo.customer.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class JpaCustomerRepository implements CustomerRepository {
    private final SpringDataCustomerRepository repository;

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
