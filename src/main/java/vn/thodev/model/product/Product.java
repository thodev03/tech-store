package vn.thodev.model.product;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import tools.jackson.databind.JsonNode;
import vn.thodev.model.utils.JsonNodeConverter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "product_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tag_id", nullable = false)
    )
    private Set<Tag> tags = new HashSet<>();


    @Column(name = "specifications", columnDefinition = "JSON")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode specifications;
}
