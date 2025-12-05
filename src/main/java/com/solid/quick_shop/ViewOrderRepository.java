package com.solid.quick_shop;

public interface ViewOrderRepository {
    Order findById(long orderId);
}
