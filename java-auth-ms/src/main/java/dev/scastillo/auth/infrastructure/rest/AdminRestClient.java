package dev.scastillo.auth.infrastructure.rest;

import dev.scastillo.auth.infrastructure.rest.dto.AdminUserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class AdminRestClient {
    private final RestTemplate restTemplate;

    @Value("${external.services.admin.base-url}")
    private String adminServiceBaseUrl;
    public AdminRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Optional<AdminUserResponse> getAdminUserByEmail(String email) {
        String url = String.format("%s/api/admin/users/email/%s", adminServiceBaseUrl, email);
        try {
            AdminUserResponse response = restTemplate.getForObject(url, AdminUserResponse.class);
            return Optional.ofNullable(response);
        } catch (Exception e) {
            // Log the exception if needed
            return Optional.empty();
        }
    }
    public Optional<AdminUserResponse> getAdminUserById(String id) {
        String url = String.format("%s/api/admin/users/%s", adminServiceBaseUrl, id);
        try {
            AdminUserResponse response = restTemplate.getForObject(url, AdminUserResponse.class);
            return Optional.ofNullable(response);
        } catch (Exception e) {
            // Log the exception if needed
            return Optional.empty();
        }
    }
}
