package vn.thodev.model.wish;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.authentication.User;
import vn.thodev.model.product.Product;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "preorder", uniqueConstraints = @UniqueConstraint(name = "uc_preorder", columnNames = {"user_id", "product_id"}))
public class Preorder extends AbstractEntity<Long> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "status",nullable = false, columnDefinition = "SMALLINT")
    private Integer status;
}
