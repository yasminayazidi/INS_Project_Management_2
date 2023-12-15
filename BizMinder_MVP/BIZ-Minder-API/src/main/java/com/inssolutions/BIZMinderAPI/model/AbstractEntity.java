package com.inssolutions.BIZMinderAPI.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private String createdBy;
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedBy
    private String modifiedBy;
    @LastModifiedDate
    private Instant modifiedAt;
}
