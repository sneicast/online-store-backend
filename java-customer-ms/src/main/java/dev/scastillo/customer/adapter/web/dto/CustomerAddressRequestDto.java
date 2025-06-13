package dev.scastillo.customer.adapter.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAddressRequestDto {
    private String title;

    private String address;

    private String city;

    private String postalCode;

    private Boolean isDefault;


}
