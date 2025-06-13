package dev.scastillo.auth.infrastructure.rest;

import dev.scastillo.auth.domain.service.CustomerServicePort;
import dev.scastillo.auth.infrastructure.rest.dto.CustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CustomerServiceAdapter implements CustomerServicePort {
    private final CustomerRestClient client;
    @Override
    public Optional<CustomerResponse> getCustomerByUsername(String username) {
        return client.getCustomerByUserName(username);
    }

    @Override
    public Optional<CustomerResponse> getCustomerById(String id) {
        return client.getCustomerById(id);
    }
}
