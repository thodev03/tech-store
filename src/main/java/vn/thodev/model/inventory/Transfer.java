package vn.thodev.model.inventory;

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
@Table(name = "transfer")
public class Transfer extends AbstractEntity<Long> {
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "export_docket_id", referencedColumnName = "id", nullable = false, unique = true)
    private Docket exportDocket;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "import_docket_id", referencedColumnName = "id", nullable = false, unique = true)
    private Docket importDocket;

    @Column(name = "note")
    private String note;
}
