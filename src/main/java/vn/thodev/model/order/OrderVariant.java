package vn.thodev.model.order;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.product.Variant;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_variant")
public class OrderVariant extends AbstractEntity<Long> {
    @EmbeddedId
    private OrderVariantKey orderVariantKey = new OrderVariantKey();

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @MapsId("variantId")
    @JoinColumn(name = "variant_id", nullable = false)
    private Variant variant;

    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(15,5)")
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "amount", nullable = false, columnDefinition = "DECIMAL(15,5)")
    private BigDecimal amount;
}
