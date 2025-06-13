package dev.scastillo.customer.domain.service;

import dev.scastillo.customer.domain.model.CustomerAddress;

import java.util.List;
import java.util.UUID;

public interface CustomerAddressService {
    CustomerAddress createCustomerAddress(UUID customerId, CustomerAddress customerAddress);
    CustomerAddress getCustomerAddressById(UUID customerId, UUID id);
    List<CustomerAddress> getCustomerAddressByCustomerId(UUID customerId);
    CustomerAddress updateCustomerAddress(UUID customerId, CustomerAddress customerAddress);
    void deleteCustomerAddress(UUID customerId, UUID id);
}
