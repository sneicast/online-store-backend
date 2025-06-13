package dev.scastillo.auth.infrastructure.rest;

import dev.scastillo.auth.domain.service.AdminServicePort;
import dev.scastillo.auth.infrastructure.rest.dto.AdminUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AdminServiceAdapter implements AdminServicePort {
    private final AdminRestClient client;

    @Override
    public Optional<AdminUserResponse> getAdminUserByEmail(String email) {
        return client.getAdminUserByEmail(email);
    }

    @Override
    public Optional<AdminUserResponse> getAdminUserById(String id) {
        return client.getAdminUserById(id);
    }

}
