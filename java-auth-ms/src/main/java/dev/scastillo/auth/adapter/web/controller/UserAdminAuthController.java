package dev.scastillo.auth.adapter.web.controller;

import dev.scastillo.auth.adapter.web.dto.LoginRequestDto;
import dev.scastillo.auth.adapter.web.dto.LoginResponseDto;
import dev.scastillo.auth.domain.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/auth")
@AllArgsConstructor
public class UserAdminAuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto loginAdmin(@RequestBody LoginRequestDto request) {
        var response = authService.loginAdmin(request.getUsername(), request.getPassword());
        return LoginResponseDto.builder()
                .accessToken(response.getAccessToken())
                .build();
    }

}
