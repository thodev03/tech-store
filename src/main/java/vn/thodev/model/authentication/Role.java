package vn.thodev.model.authentication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role extends AbstractEntity<Integer> {
    @Column(name = "code",nullable = false, unique = true, length = 35)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users= new HashSet<>();
}
