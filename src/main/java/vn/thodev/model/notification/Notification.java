package vn.thodev.model.notification;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.authentication.User;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "brand")
public class Notification {
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "anchor")
    private String anchor;

    @Column(name = "status",nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
