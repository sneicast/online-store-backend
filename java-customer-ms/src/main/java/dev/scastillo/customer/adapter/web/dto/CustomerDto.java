package dev.scastillo.customer.adapter.web.dto;

import lombok.*;
import java.time.OffsetDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Boolean status;
    private String username;
    private OffsetDateTime createAt;
    private OffsetDateTime updateAt;
}
