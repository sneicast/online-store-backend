package dev.scastillo.customer.infrastructure.repository;

import dev.scastillo.customer.domain.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataCustomerAddressRepository extends JpaRepository<CustomerAddress, UUID> {
    List<CustomerAddress> findAllByCustomerId(UUID customerId);
    Optional<CustomerAddress> findByCustomerIdAndId(UUID customerId, UUID id);
    void deleteByIdAndCustomerId(UUID id, UUID customerId);
}
