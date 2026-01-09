package vn.thodev.model.inventory;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.address.Address;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "warehouse")
public class Warehouse extends AbstractEntity<Long> {
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private Address address;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL, orphanRemoval = true)
    List<StorageLocation> storageLocations = new ArrayList<>();
}
