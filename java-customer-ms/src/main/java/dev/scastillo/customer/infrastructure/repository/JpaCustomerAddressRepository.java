package dev.scastillo.customer.infrastructure.repository;

import dev.scastillo.customer.domain.model.CustomerAddress;
import dev.scastillo.customer.domain.repository.CustomerAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class JpaCustomerAddressRepository implements CustomerAddressRepository {
    private final SpringDataCustomerAddressRepository repository;

    @Override
    public CustomerAddress save(CustomerAddress customerAddress) {
        return  repository.save(customerAddress);
    }

    @Override
    public Optional<CustomerAddress> findByCustomerIdAndId(UUID customerId, UUID id) {
        return repository.findByCustomerIdAndId(customerId, id);
    }

    @Override
    public List<CustomerAddress> findAllByCustomerId(UUID customerId) {
        return repository.findAllByCustomerId(customerId);
    }

    @Override
    public void deleteByIdAndCustomerId(UUID id, UUID customerId) {
        repository.deleteByIdAndCustomerId(id, customerId);
    }
}
