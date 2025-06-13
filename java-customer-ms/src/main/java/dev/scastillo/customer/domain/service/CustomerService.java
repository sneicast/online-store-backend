package dev.scastillo.customer.domain.service;

import dev.scastillo.customer.domain.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(UUID id);
    Customer getCustomerByUsername(String username);
}
