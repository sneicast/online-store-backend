package dev.scastillo.admin.adapter.web.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUserResponseDto {
    private String id;

    private String fullName;

    private Boolean status;

    private String email;

    private OffsetDateTime createAt;

    private OffsetDateTime updateAt;
}
