package vn.thodev.model.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import tools.jackson.databind.JsonNode;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.cart.CartVariant;
import vn.thodev.model.image.Image;
import vn.thodev.model.inventory.CountVariant;
import vn.thodev.model.inventory.DocketVariant;
import vn.thodev.model.inventory.PurchaseOrder;
import vn.thodev.model.inventory.PurchaseOrderVariant;
import vn.thodev.model.order.OrderVariant;
import vn.thodev.model.utils.JsonNodeConverter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "variant",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "variant", cascade = CascadeType.ALL)
    private Set<CountVariant> countVariants = new HashSet<>();

    @OneToMany(mappedBy = "variant",cascade = CascadeType.ALL)
    private Set<PurchaseOrderVariant> purchaseOrderVariants = new HashSet<>();

    @OneToMany(mappedBy = "variant", cascade = CascadeType.ALL)
    private Set<CartVariant> cartVariants = new HashSet<>();

    @OneToMany(mappedBy = "variant", cascade = CascadeType.ALL)
    private Set<OrderVariant> orderVariants = new HashSet<>();

    @OneToMany(mappedBy = "variant" , cascade = CascadeType.ALL)
    private Set<DocketVariant> docketVariants = new HashSet<>();
}
