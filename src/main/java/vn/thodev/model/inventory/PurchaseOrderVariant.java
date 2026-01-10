package vn.thodev.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.product.Variant;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase_order_variant")
public class PurchaseOrderVariant {
    @EmbeddedId
    private PurchaseOrderVariantKey purchaseOrderVariantKey = new PurchaseOrderVariantKey();

    @ManyToOne
    @MapsId("purchaseOrderId")
    @JoinColumn(name = "purchase_order_id", nullable = false)
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @MapsId("variantId")
    @JoinColumn(name = "variant_id", nullable = false)
    private Variant variant;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "amount", nullable = false)
    private Double amount;
}
