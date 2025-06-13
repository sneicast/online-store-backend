package dev.scastillo.customer.adapter.web.dto.auth;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";
    private String expiresIn;
}
