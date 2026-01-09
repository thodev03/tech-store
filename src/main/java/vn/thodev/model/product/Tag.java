package vn.thodev.model.product;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tag")
public class Tag extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @ManyToMany(mappedBy = "tags")
    private Set<Product> products = new HashSet<>();
}
