package dev.scastillo.admin.infrastructure.repository;

import dev.scastillo.admin.domain.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataAdminUserRepository  extends JpaRepository<AdminUser, UUID> {
    Optional<AdminUser> findByEmail(String email);
}
