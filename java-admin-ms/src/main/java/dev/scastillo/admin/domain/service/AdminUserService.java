package dev.scastillo.admin.domain.service;

import dev.scastillo.admin.domain.model.AdminUser;

import java.util.UUID;

public interface AdminUserService {
    AdminUser createAdminUser(AdminUser adminUser);
    AdminUser getAdminUserById(UUID id);
    AdminUser getAdminUserByEmail(String email);
    AdminUser updateAdminUser(UUID id, AdminUser adminUser);
}
