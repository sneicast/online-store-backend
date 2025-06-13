package dev.scastillo.auth.infrastructure.rest;

import dev.scastillo.auth.infrastructure.rest.dto.CustomerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class CustomerRestClient {

    private final RestTemplate restTemplate;

    @Value("${external.services.customer.base-url}")
    private String customerServiceBaseUrl;

    public CustomerRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

     public Optional<CustomerResponse> getCustomerByUserName(String username) {
         String url = String.format("%s/api/customers/username/%s", customerServiceBaseUrl, username);
        try {
            CustomerResponse response = restTemplate.getForObject(url, CustomerResponse.class);
            return Optional.ofNullable(response);
        } catch (Exception e) {
            // Log the exception if needed
            return Optional.empty();
        }
    }
    public Optional<CustomerResponse> getCustomerById(String id) {
        String url = String.format("%s/api/customers/%s", customerServiceBaseUrl, id);
        try {
            CustomerResponse response = restTemplate.getForObject(url, CustomerResponse.class);
            return Optional.ofNullable(response);
        } catch (Exception e) {
            // Log the exception if needed
            return Optional.empty();
        }
    }
}
