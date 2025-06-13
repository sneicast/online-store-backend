package dev.scastillo.auth.application.service;

import dev.scastillo.auth.adapter.web.dto.UserInfoDto;
import dev.scastillo.auth.domain.service.AdminServicePort;
import dev.scastillo.auth.domain.service.AuthService;
import dev.scastillo.auth.domain.service.CustomerServicePort;
import dev.scastillo.auth.domain.service.dto.AuthLoginResponse;
import dev.scastillo.auth.infrastructure.rest.dto.AdminUserResponse;
import dev.scastillo.auth.infrastructure.rest.dto.CustomerResponse;
import dev.scastillo.auth.shared.enums.ClientType;
import dev.scastillo.auth.shared.util.JwtUtil;
import dev.scastillo.auth.shared.util.dto.JwtClaimCustom;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final CustomerServicePort customerServicePort;
    private final AdminServicePort adminServicePort;
    private final JwtUtil jwtUtils;

    @Override
    public AuthLoginResponse loginCustomer(String username, String password) {
        Optional<CustomerResponse> customerResponse = customerServicePort.getCustomerByUsername(username);
        if(customerResponse.isPresent()) {
            CustomerResponse customer = customerResponse.get();
            if (customer.getPasswordHash().equals(password)) {

                return AuthLoginResponse.builder()
                        .accessToken(getToken(customer.getId(), JwtClaimCustom.builder().userId(customer.getId()).fullName(customer.getName()).typeUser(ClientType.CUSTOMER).build()))
                        .build();
            } else {
                throw new IllegalArgumentException("Invalid password");
            }
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    @Override
    public AuthLoginResponse loginAdmin(String username, String password) {
        Optional<AdminUserResponse> adminUserResponse = adminServicePort.getAdminUserByEmail(username);
        if (adminUserResponse.isPresent()) {
            AdminUserResponse adminUser = adminUserResponse.get();
            if (adminUser.getPasswordHash().equals(password)) {
                return AuthLoginResponse.builder()
                        .accessToken(getToken(adminUser.getId(), JwtClaimCustom.builder().userId(adminUser.getId()).fullName(adminUser.getFullName()).typeUser(ClientType.USER_ADMIN).build()))
                        .build();
            } else {
                throw new IllegalArgumentException("Invalid password");
            }
        } else {
            throw new IllegalArgumentException("Admin user not found");
        }
    }

    @Override
    public UserInfoDto validateToken(String token) {
        boolean isValid = jwtUtils.isTokenValid(token);
        if (isValid) {
            JwtClaimCustom dataJwt = jwtUtils.getAllClaims(token);


            return UserInfoDto.builder()
                    .id(dataJwt.getUserId())
                    .fullName(dataJwt.getFullName())
                    .build();
        }
        throw new IllegalArgumentException("Invalid token");
    }

    private String getToken(String id, JwtClaimCustom dataJwt) {
        return jwtUtils.generateToken(id, dataJwt);
    }
}
