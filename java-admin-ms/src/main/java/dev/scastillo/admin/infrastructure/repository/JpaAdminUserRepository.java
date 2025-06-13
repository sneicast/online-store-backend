package dev.scastillo.admin.infrastructure.repository;

import dev.scastillo.admin.domain.model.AdminUser;
import dev.scastillo.admin.domain.repository.AdminUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class JpaAdminUserRepository implements AdminUserRepository {
    private final SpringDataAdminUserRepository repository;

    @Override
    public AdminUser save(AdminUser adminUser) {
        return repository.save(adminUser);
    }

    @Override
    public Optional<AdminUser> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<AdminUser> findById(UUID id) {
        return repository.findById(id);
    }
}
