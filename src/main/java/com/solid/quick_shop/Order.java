package com.solid.quick_shop;

import lombok.Data;

@Data
public class Order {
    private long id;
    private long orderTotal;
    private String type;
}
