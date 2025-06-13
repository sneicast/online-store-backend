package dev.scastillo.customer.adapter.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidateCustomerResponseDto {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Boolean status;
    private String username;
    private String passwordHash;
}
