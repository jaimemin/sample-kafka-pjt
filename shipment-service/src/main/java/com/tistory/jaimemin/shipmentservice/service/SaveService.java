package com.tistory.jaimemin.shipmentservice.service;

import com.tistory.jaimemin.shipmentservice.dto.CheckOutDto;
import com.tistory.jaimemin.shipmentservice.entity.ShipmentCheckOutEntity;
import com.tistory.jaimemin.shipmentservice.repository.ShipmentCheckOutRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveService {

    private final ShipmentCheckOutRepository shipmentCheckOutRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Long saveCheckOutData(CheckOutDto checkOutDto) {
        ShipmentCheckOutEntity shipmentCheckOutEntity = modelMapper.map(checkOutDto, ShipmentCheckOutEntity.class);
        ShipmentCheckOutEntity savedEntity = shipmentCheckOutRepository.save(shipmentCheckOutEntity);

        return savedEntity.getShipmentId();
    }
}
