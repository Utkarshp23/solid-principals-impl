package com.solid.quick_shop;

public interface NotificationService {
    void sendOrderConfirmation(long orderId);
    boolean isApplicable(Order order);
}
