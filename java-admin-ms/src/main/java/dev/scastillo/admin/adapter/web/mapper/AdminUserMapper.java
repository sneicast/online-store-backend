package dev.scastillo.admin.adapter.web.mapper;

import dev.scastillo.admin.adapter.web.dto.AdminUserRequestDto;
import dev.scastillo.admin.adapter.web.dto.AdminUserResponseDto;
import dev.scastillo.admin.domain.model.AdminUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminUserMapper {
    AdminUser toDomain(AdminUserRequestDto dto);
    AdminUserResponseDto toDto(AdminUser adminUser);
}
