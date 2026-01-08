package vn.thodev.model.authentication;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;

import java.time.Instant;

@Getter
@Setter
@Entity
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "refresh_token")
public class RefreshToken extends AbstractEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "expiry_date",nullable = false)
    private Instant expiryDate;
}
