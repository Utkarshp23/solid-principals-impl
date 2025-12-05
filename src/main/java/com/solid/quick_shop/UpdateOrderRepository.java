package com.solid.quick_shop;

public interface UpdateOrderRepository extends ViewOrderRepository {
    void save(Order order);
}
