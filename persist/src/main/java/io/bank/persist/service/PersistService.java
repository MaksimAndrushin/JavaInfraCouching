package io.bank.persist.service;

import io.bank.persist.model.CalculatedOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersistService {
    public Integer persistCalculatedOrder(CalculatedOrder calculatedOrder) {
        Integer persistedOrderId = calculatedOrder.getCalculatedValue() + calculatedOrder.getValue() + calculatedOrder.getId();
        log.info("Persisting order. Order persisted ID = {}", persistedOrderId);

        return persistedOrderId;
    }
}
