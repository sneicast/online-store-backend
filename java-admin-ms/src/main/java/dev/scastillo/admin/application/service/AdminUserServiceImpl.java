package dev.scastillo.admin.application.service;

import dev.scastillo.admin.domain.model.AdminUser;
import dev.scastillo.admin.domain.repository.AdminUserRepository;
import dev.scastillo.admin.domain.service.AdminUserService;
import dev.scastillo.admin.shared.util.DateTimeUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserRepository adminUserRepository;

    @Override
    public AdminUser createAdminUser(AdminUser adminUser) {
        adminUser.setId(UUID.randomUUID());
        adminUser.setCreateAt(DateTimeUtils.now());
        adminUser.setUpdateAt(DateTimeUtils.now());
        return adminUserRepository.save(adminUser);
    }

    @Override
    public AdminUser getAdminUserById(UUID id) {
        return adminUserRepository.findById(id).orElseThrow( () ->
            new RuntimeException("Admin user not found with id: " + id));
    }

    @Override
    public AdminUser getAdminUserByEmail(String email) {
        return adminUserRepository.findByEmail(email).orElseThrow( () ->
            new RuntimeException("Admin user not found with email: " + email));
    }

    @Override
    public AdminUser updateAdminUser(UUID id, AdminUser adminUser) {
    AdminUser existingAdminUser = adminUserRepository.findById(id).orElseThrow(() ->
            new RuntimeException("Admin user not found with id: " + id));

        existingAdminUser.setEmail(adminUser.getEmail());
        existingAdminUser.setFullName(adminUser.getFullName());
        existingAdminUser.setStatus(adminUser.getStatus());
        existingAdminUser.setUpdateAt(DateTimeUtils.now());

        return adminUserRepository.save(existingAdminUser);
    }
}
