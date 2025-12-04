package com.solid.quick_shop;

public class SmsSender implements NotificationService {
    @Override
    public void sendOrderConfirmation(long orderId) {
        // Logic to send SMS
        System.out.println("SMS sent for order id: " + orderId);
    }

    @Override
    public boolean isApplicable(Order order) {
        return order.getOrderTotal() > 1000;
    }

}
