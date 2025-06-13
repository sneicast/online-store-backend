package dev.scastillo.auth.infrastructure.rest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUserResponse {
    private String id;

    private String fullName;

    private Boolean status;

    private String email;

    private String passwordHash;
}
