package vn.thodev.model.reward;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.authentication.User;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reward_log")
public class RewardLog extends AbstractEntity<Long> {
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RewardType type;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "note", nullable = false)
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
