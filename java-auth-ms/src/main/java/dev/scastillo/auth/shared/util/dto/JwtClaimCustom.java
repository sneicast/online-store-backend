package dev.scastillo.auth.shared.util.dto;

import dev.scastillo.auth.shared.enums.ClientType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JwtClaimCustom {
    private String userId;
    private String fullName;
    private ClientType typeUser;
}
