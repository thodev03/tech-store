package vn.thodev.model.reward;

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
@Table(name = "reward_strategy")
public class RewardStrategy extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    @Enumerated(EnumType.STRING)
    private RewardType code;

    @Column(name = "formula", nullable = false)
    private String formula;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;
}
