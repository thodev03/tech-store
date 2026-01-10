package vn.thodev.model.inventory;

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
public class PurchaseOrderVariantKey implements Serializable {
    @Column(name = "purchase_order_id", nullable = false)
    Long purchaseOrderId;

    @Column(name = "variant_id", nullable = false)
    Long variantId;
}
