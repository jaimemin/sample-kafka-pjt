package com.tistory.jaimemin.checkoutservice.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "CHECKOUT_TABLE")
public class CheckOutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long checkOutId;

    @Column(name = "memberId")
    private Long memberId;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "shippingAddress")
    private String shippingAddress;

    @CreationTimestamp
    @Column(name = "createdAt")
    private Timestamp createdAt;
}
