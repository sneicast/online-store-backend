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
@RequestMapping("/api/customer/auth")
@AllArgsConstructor
public class CustomerAuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto loginCustomer(@RequestBody LoginRequestDto request) {
        var response = authService.loginCustomer(request.getUsername(), request.getPassword());
        return LoginResponseDto.builder()
                .accessToken(response.getAccessToken())
                .build();
    }
}
