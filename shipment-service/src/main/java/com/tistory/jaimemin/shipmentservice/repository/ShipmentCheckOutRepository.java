package com.tistory.jaimemin.shipmentservice.repository;

import com.tistory.jaimemin.shipmentservice.entity.ShipmentCheckOutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ShipmentCheckOutRepository extends JpaRepository<ShipmentCheckOutEntity, Long> {
}
