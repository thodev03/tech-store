package vn.thodev.model.address;

import jakarta.persistence.*;
import lombok.*;
import vn.thodev.model.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "province")
public class Province extends AbstractEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, length = 35)
    private String code;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<District> districts = new ArrayList<>();

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();
}
