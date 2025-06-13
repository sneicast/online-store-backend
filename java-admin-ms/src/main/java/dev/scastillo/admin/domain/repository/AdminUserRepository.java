package dev.scastillo.admin.domain.repository;

import dev.scastillo.admin.domain.model.AdminUser;

import java.util.Optional;
import java.util.UUID;

public interface AdminUserRepository {
    AdminUser save(AdminUser adminUser);
    Optional<AdminUser> findByEmail(String email);
    Optional<AdminUser> findById(UUID id);
}
