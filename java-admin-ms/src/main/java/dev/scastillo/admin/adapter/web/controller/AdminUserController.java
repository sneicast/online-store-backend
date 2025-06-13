package dev.scastillo.admin.adapter.web.controller;

import dev.scastillo.admin.adapter.web.dto.AdminUserRequestDto;
import dev.scastillo.admin.adapter.web.dto.AdminUserResponseDto;
import dev.scastillo.admin.adapter.web.mapper.AdminUserMapper;
import dev.scastillo.admin.domain.model.AdminUser;
import dev.scastillo.admin.domain.service.AdminUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/users")
@AllArgsConstructor
public class AdminUserController {
    private final AdminUserService adminUserService;
    private  final AdminUserMapper adminUserMapper;

    @PostMapping
    public AdminUserResponseDto createAdminUser(@RequestBody AdminUserRequestDto request) {
        AdminUser adminUser = adminUserService.createAdminUser(adminUserMapper.toDomain(request));
        return adminUserMapper.toDto(adminUser);
    }

    @GetMapping("/{id}")
    public AdminUserResponseDto getAdminUserById(@PathVariable UUID id) {
        AdminUser adminUser = adminUserService.getAdminUserById(id);
        return adminUserMapper.toDto(adminUser);
    }

    @GetMapping("/email/{email}")
    public AdminUserResponseDto getAdminUserByEmail(@PathVariable String email) {
        AdminUser adminUser = adminUserService.getAdminUserByEmail(email);
        return adminUserMapper.toDto(adminUser);
    }
    @PutMapping("/{id}")
    public AdminUserResponseDto updateAdminUser(@PathVariable UUID id, @RequestBody AdminUserRequestDto request) {
        AdminUser adminUser = adminUserService.updateAdminUser(id, adminUserMapper.toDomain(request));
        return adminUserMapper.toDto(adminUser);
    }



}
