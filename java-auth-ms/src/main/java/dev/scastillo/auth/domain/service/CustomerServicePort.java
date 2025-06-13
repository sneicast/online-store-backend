package dev.scastillo.auth.domain.service;

import dev.scastillo.auth.infrastructure.rest.dto.CustomerResponse;

import java.util.Optional;

public interface CustomerServicePort {
    Optional<CustomerResponse> getCustomerByUsername(String username);
    Optional<CustomerResponse> getCustomerById(String id);
}
