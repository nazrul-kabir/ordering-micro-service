package com.github.nazrulkabir.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    long productId;

    @Column
    int quantity;

    @Column
    OrderState orderState = OrderState.RUNNING;


    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;

    @UpdateTimestamp
    Timestamp lastModified;
}
