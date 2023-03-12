package io.bank.persist.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CalculatedOrder {

    private final Integer id;
    private final String name;
    private final Integer value;
    private final Integer calculatedValue;

    public CalculatedOrder(Integer id, String name, Integer value, Integer caculatedValue) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.calculatedValue = caculatedValue;
    }
}
