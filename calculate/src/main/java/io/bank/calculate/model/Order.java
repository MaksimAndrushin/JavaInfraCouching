package io.bank.calculate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Order {

    private final Integer id;
    private final String name;
    private final Integer value;
}
