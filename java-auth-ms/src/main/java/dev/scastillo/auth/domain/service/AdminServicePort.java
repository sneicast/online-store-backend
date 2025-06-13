package dev.scastillo.auth.domain.service;

import dev.scastillo.auth.infrastructure.rest.dto.AdminUserResponse;

import java.util.Optional;

public interface AdminServicePort {

    Optional<AdminUserResponse> getAdminUserByEmail(String email);
    Optional<AdminUserResponse> getAdminUserById(String id);
}
