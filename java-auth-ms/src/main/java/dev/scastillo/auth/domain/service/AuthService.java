package dev.scastillo.auth.domain.service;

import dev.scastillo.auth.adapter.web.dto.UserInfoDto;
import dev.scastillo.auth.domain.service.dto.AuthLoginResponse;

public interface AuthService {
    AuthLoginResponse loginCustomer(String username, String password);
    AuthLoginResponse loginAdmin(String username, String password);
    UserInfoDto validateToken (String token);

}
