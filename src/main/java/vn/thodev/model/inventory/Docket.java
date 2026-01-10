package vn.thodev.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.order.Order;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "docket")
public class Docket extends AbstractEntity<Long> {
    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reason_id", nullable = false)
    private DocketReason reason;

    @OneToMany(mappedBy = "docket", cascade = CascadeType.ALL)
    private Set<DocketVariant> docketVariant = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "note")
    private String note;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT")
    private Integer status;

}
