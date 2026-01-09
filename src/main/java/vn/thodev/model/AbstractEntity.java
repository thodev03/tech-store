package vn.thodev.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Setter
@Getter
@Accessors(chain = true)
@MappedSuperclass
public abstract class AbstractEntity<T>   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private T id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt = Instant.now();

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private T createdBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    private T updatedBy;
}
