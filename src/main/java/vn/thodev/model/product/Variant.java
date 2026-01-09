package vn.thodev.model.product;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;
import tools.jackson.databind.JsonNode;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.utils.JsonNodeConverter;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "variant")
public class Variant extends AbstractEntity<Long> {
    @Column(name = "sku", nullable = false, unique = true)
    private String sku;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "properties", columnDefinition = "JSON")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode properties;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;
}
