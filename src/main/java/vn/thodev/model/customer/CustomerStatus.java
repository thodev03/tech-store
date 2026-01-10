package vn.thodev.model.customer;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_status")
public class CustomerStatus extends AbstractEntity<Integer> {
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "status", nullable = false ,columnDefinition = "SMALLINT")
    private Integer status;

    @OneToMany(mappedBy = "customerStatus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers= new ArrayList<>();
}
