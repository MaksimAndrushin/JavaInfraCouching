package io.bank.order.model;

import io.bank.order.utils.OrderIdSequence;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Order {

    private final Integer id;
    private final String name;
    private final Integer value;

    public Order(String name, Integer value) {
        this.id = OrderIdSequence.generateOrderId();
        this.name = name;
        this.value = value;
    }
}
