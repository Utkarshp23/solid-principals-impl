package com.solid.quick_shop.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private  AtomicInteger count = new AtomicInteger(0);

    public  void increment() {
        count.incrementAndGet(); // safe
    }

    public int getCount() {
        return count.get();
    }

}
