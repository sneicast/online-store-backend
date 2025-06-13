package dev.scastillo.auth.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Boolean status;
    private String username;
    private String passwordHash;
}
