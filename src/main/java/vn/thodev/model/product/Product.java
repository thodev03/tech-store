package vn.thodev.model.product;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import tools.jackson.databind.JsonNode;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.image.Image;
import vn.thodev.model.promotion.Promotion;
import vn.thodev.model.review.Review;
import vn.thodev.model.utils.JsonNodeConverter;
import vn.thodev.model.wish.Preorder;
import vn.thodev.model.wish.Wish;

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
@Table(name = "product")
public class Product extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

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

    @Column(name = "properties", columnDefinition = "JSON")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode properties;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guarantee_id")
    private Guarantee guarantee;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "product")
    private Set<Promotion> promotions = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private List<Preorder> preorders = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Wish> wishes = new ArrayList<>();
}
