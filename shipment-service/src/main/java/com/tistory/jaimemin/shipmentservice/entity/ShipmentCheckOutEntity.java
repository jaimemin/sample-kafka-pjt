package com.tistory.jaimemin.shipmentservice.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "SHIPMENT_CHECKOUT_TABLE")
public class ShipmentCheckOutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shipmentId;

    @Column(name = "checkOutId")
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
