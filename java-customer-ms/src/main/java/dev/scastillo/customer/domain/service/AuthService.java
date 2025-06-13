package dev.scastillo.customer.domain.service;

import dev.scastillo.customer.adapter.web.dto.auth.LoginRequestDto;
import dev.scastillo.customer.adapter.web.dto.auth.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequest);
}
