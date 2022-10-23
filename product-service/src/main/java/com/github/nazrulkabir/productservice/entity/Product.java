package com.github.nazrulkabir.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String name;

    @Column
    int currentStock;

    @Column
    String description;

    @Column
    String type;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;

    @UpdateTimestamp
    Timestamp lastModified;
}
