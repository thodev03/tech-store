package vn.thodev.model.employee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status",nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();
}
