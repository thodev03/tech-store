package vn.thodev.model.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.address.Address;

import java.util.ArrayList;
import java.util.List;

@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "office")
public class Office extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status",nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false, unique = true)
    private Address address;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Employee> employees = new ArrayList<>();
}
