package dev.scastillo.admin.adapter.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUserRequestDto {
    private String fullName;

    private Boolean status;

    private String email;

    private String passwordHash;
}
