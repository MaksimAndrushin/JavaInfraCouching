package io.bank.persist.controller;

import io.bank.persist.model.CalculatedOrder;
import io.bank.persist.service.PersistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PersistController {

    private final PersistService persistService;

    @Autowired
    public PersistController(PersistService persistService) {
        this.persistService = persistService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "persist")
    public Integer persistOrder(@RequestBody CalculatedOrder calculatedOrder) {
        log.info("Calculated order in request = {}", calculatedOrder);
        return persistService.persistCalculatedOrder(calculatedOrder);
    }
}
