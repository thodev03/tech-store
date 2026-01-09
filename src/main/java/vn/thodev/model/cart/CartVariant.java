package vn.thodev.model.cart;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.product.Variant;

import java.time.Instant;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_variant")
public class CartVariant {
    @EmbeddedId
    private CartVariantKey cartVariantKey = new CartVariantKey();

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @MapsId("variantId")
    @JoinColumn(name = "variant_id", nullable = false)
    private Variant variant;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
