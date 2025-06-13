package dev.scastillo.customer.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer_payment_methods")
public class CustomerPaymentMethod {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "account_last4", length = 4)
    private String accountLast4;

    @Column(name = "token")
    private String token;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "create_at")
    private OffsetDateTime createAt;

    @Column(name = "provider", length = 100)
    private String provider;
}
