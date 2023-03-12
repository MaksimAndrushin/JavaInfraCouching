package io.bank.calculate.controller;

import io.bank.calculate.model.Order;
import io.bank.calculate.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CalculateController {

    private final CalculateService calculateService;

    @Autowired
    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "calculate")
    public Integer calculateOrder(@RequestBody Order order) {
        log.info("Order in request = {}", order);
        return calculateService.calculateOrder(order);
    }
}
