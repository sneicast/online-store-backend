package dev.scastillo.customer.adapter.web.dto;


import lombok.*;
import java.time.OffsetDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAddressDto {
    private String id;

    private String address;

    private String city;

    private String postalCode;

    private Boolean isDefault;

    private String title;

    private OffsetDateTime createAt;

    private OffsetDateTime updateAt;
}
