package vn.thodev.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "count")
public class Count extends AbstractEntity<Long> {
    @Column(name = "code",nullable = false, unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @OneToMany(mappedBy = "count", cascade = CascadeType.ALL)
    private Set<CountVariant> countVariants = new HashSet<>();

    @Column(name = "note")
    private String note;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;
}
