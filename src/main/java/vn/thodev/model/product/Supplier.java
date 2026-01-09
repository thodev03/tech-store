package vn.thodev.model.product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
public class Supplier {
    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "contact_fullname")
    private String contactFullname;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "website")
    private String website;

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private String note;

    @Column(name = "status", nullable = false, columnDefinition = "SMALLINT")
    private Integer status;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();
}
