package vn.thodev.model.image;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.product.Product;
import vn.thodev.model.product.Variant;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "image")
public class Image extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "path", nullable = false, unique = true)
    private String path;

    @Column(name = "content_type", nullable = false)
    private String contentType;

    @Column(name = "size", nullable = false)
    private Long size;

    @Column(name = "group", nullable = false)
    private String group;

    @Column(name = "is_thumbnail", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean isThumbnail;

    @Column(name = "is_eliminated", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean isEliminated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id")
    private Variant variant;
}
