package dev.scastillo.auth.adapter.web.controller;

import dev.scastillo.auth.adapter.web.dto.UserInfoDto;
import dev.scastillo.auth.adapter.web.dto.ValidateTokenRequestDto;
import dev.scastillo.auth.domain.service.AuthService;
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


    @PostMapping("/validate-token")
    public UserInfoDto validateToken(@RequestBody ValidateTokenRequestDto request){
        return authService.validateToken(request.getToken());


    }

}
