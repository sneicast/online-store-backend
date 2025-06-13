package dev.scastillo.auth.domain.service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthLoginResponse {
    private String accessToken;
}
