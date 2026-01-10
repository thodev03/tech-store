package vn.thodev.model.waybill;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "waybill_log")
public class WaybillLog extends AbstractEntity<Long> {
    @Column(name = "previous_status")
    private Integer previousStatus;

    @Column(name = "current_status")
    private Integer currentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "waybill_id", nullable = false)
    private Waybill waybill;
}
