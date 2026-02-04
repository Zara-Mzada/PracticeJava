package com.student.dao.entity;

import com.student.util.enums.BrandEnum;
import com.student.util.enums.OSEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "phone")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String model;
    @Enumerated(value = EnumType.STRING)
    BrandEnum brand;

    @Enumerated(value = EnumType.STRING)
    OSEnum osSystem;

    Double price;
    Integer stockQuantity;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
}
