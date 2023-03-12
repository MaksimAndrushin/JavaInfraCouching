package io.bank.order.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderIdSequence {

    private static final AtomicInteger orderIdSequence = new AtomicInteger();

    public static Integer generateOrderId() {
        return orderIdSequence.addAndGet(1);
    }

}
