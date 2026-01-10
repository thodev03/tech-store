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
public class DocketVariantKey implements Serializable {
    @Column(name = "docket_id", nullable = false)
    Long docketId;

    @Column(name = "variant_id", nullable = false)
    Long variantId;
}
