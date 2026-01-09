package vn.thodev.model.inventory;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@ToString
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CountVariantKey {
    @Column(name = "count_id", nullable = false)
    Long countId;

    @Column(name = "variant_id", nullable = false)
    Long variantId;
}
