package vn.thodev.model.product;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specification")
public class Specification extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;
}
