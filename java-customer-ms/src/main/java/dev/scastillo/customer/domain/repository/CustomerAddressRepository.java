package dev.scastillo.customer.domain.repository;

import dev.scastillo.customer.domain.model.CustomerAddress;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerAddressRepository {
    CustomerAddress save(CustomerAddress customerAddress);
    Optional<CustomerAddress> findByCustomerIdAndId(UUID customerId, UUID id);
    List<CustomerAddress> findAllByCustomerId(UUID customerId);
    void deleteByIdAndCustomerId(UUID id, UUID customerId);
}
