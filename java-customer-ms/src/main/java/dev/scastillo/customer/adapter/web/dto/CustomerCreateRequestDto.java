package dev.scastillo.customer.adapter.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCreateRequestDto {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private String passwordHash;
}
