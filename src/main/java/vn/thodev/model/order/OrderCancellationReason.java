package vn.thodev.model.order;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_cancellation_reason")
public class OrderCancellationReason extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "note")
    private String note;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @OneToMany(mappedBy = "orderCancellationReason", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
}
