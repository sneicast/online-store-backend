package dev.scastillo.customer.adapter.web.controller;

import dev.scastillo.customer.adapter.web.dto.auth.LoginRequestDto;
import dev.scastillo.customer.adapter.web.dto.auth.LoginResponseDto;
import dev.scastillo.customer.domain.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto request){
        return authService.login(request);
    }
}
