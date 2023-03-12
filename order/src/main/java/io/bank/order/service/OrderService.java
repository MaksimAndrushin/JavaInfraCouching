package io.bank.order.service;

import io.bank.order.model.CalculatedOrder;
import io.bank.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderService {

    @Value("${calculate.service.url}")
    private String calculateServiceUrl;
    @Value("${persist.service.url}")
    private String persistServiceUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Integer CreateOrder() {

        Order order = new Order("New Order", 1024);
        log.info("Create order {}", order);

        Integer calculationResult = calculateOrder(order);

        CalculatedOrder calculatedOrder = new CalculatedOrder(order.getId(), order.getName(), order.getValue(), calculationResult);

        Integer peresistedOrderId = persistCalculatedOrder(calculatedOrder);

        return peresistedOrderId;
    }

    private Integer calculateOrder(Order order) {
        ResponseEntity<Integer> response = restTemplate.postForEntity(calculateServiceUrl, order, Integer.class);

        Integer calculationResult = response.getBody();
        log.info("Calculation result = {}", calculationResult);

        return calculationResult;
    }

    private Integer persistCalculatedOrder(CalculatedOrder calculatedOrder) {
        ResponseEntity<Integer> response = restTemplate.postForEntity(persistServiceUrl, calculatedOrder, Integer.class);

        Integer persistedOrderId = response.getBody();
        log.info("Persisted order ID = {}", persistedOrderId);

        return persistedOrderId;
    }

}
