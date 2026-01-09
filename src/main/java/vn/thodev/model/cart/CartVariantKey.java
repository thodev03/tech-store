package vn.thodev.model.cart;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CartVariantKey implements Serializable {
    @Column(name = "cart_id", nullable = false)
    Long cartId;

    @Column(name = "variant_id", nullable = false)
    Long variantId;
}
