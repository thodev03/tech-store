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
@Table(name = "count_variant")
public class CountVariant {
    @EmbeddedId
    private CountVariantKey countVariantKey = new CountVariantKey();

    @ManyToOne
    @MapsId("countId")
    @JoinColumn(name = "count_id", nullable = false)
    private Count count;

    @ManyToOne
    @MapsId("variantId")
    @JoinColumn(name = "variant_id", nullable = false)
    private Variant variant;

    @Column(name = "inventory", nullable = false)
    private Integer inventory;

    @Column(name = "actual_inventory", nullable = false)
    private Integer actualInventory;
}
