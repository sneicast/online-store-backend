package dev.scastillo.customer.application.service;

import dev.scastillo.customer.adapter.web.dto.auth.LoginRequestDto;
import dev.scastillo.customer.adapter.web.dto.auth.LoginResponseDto;
import dev.scastillo.customer.domain.model.Customer;
import dev.scastillo.customer.domain.service.AuthService;
import dev.scastillo.customer.domain.service.CustomerService;
import dev.scastillo.customer.shared.exception.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final CustomerService customerService;
    @Override
    public LoginResponseDto login(LoginRequestDto loginRequest) {
        Customer customer = customerService.getCustomerByUsername(loginRequest.getUsername());
        if(customer.getPasswordHash() == loginRequest.getPassword()) {
                throw new BadRequestException("Usuario o contraseña no validos " + loginRequest.getUsername());
        }
        return LoginResponseDto.builder()
                .accessToken("Mi token de acceso")
                .tokenType("Bearer")
                .expiresIn("28292202200")
                .build();
    }
}
