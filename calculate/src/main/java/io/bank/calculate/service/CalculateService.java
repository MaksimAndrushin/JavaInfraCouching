package io.bank.calculate.service;

import io.bank.calculate.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculateService {
    public Integer calculateOrder(Order order) {

        Integer calculationResult = order.getValue() * 2;
        log.info("Calculation result = {}", calculationResult);

        return calculationResult;
    }
}
