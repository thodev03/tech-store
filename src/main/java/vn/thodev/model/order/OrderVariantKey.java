package vn.thodev.model.order;

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
public class OrderVariantKey implements Serializable{
    @Column(name = "order_id", nullable = false)
    Long orderId;

    @Column(name = "variant_id", nullable = false)
    Long variantId;
}
