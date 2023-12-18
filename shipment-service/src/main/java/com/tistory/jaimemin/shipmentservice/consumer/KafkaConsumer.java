package com.tistory.jaimemin.shipmentservice.consumer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tistory.jaimemin.shipmentservice.dto.CheckOutDto;
import com.tistory.jaimemin.shipmentservice.service.SaveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final String TOPIC_NAME = "checkout.complete.v1";

    private static final String GROUP_ID = "shipment.group.v1";

    private final SaveService saveService;

    private final ObjectMapper objectMapper
            = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void recordListener(String jsonMessage) {
        try {
            CheckOutDto checkOutDto = objectMapper.readValue(jsonMessage, CheckOutDto.class);
            log.info("{}", checkOutDto);

            saveService.saveCheckOutData(checkOutDto);
        } catch (Exception e) {
            log.error(String.format("recordListener ERROR message=%s", jsonMessage), e);
        }
    }
}
