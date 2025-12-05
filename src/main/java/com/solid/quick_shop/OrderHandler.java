package com.solid.quick_shop;

import java.util.List;

public class OrderHandler {

    private final UpdateOrderRepository repository;
    private final List<NotificationService> notificationServices;

    public OrderHandler(UpdateOrderRepository repository, List<NotificationService> notificationServices) {
        this.repository = repository;
        this.notificationServices = notificationServices;
    }

    public boolean process(Order order){
        // Validate
        if (order.getOrderTotal()<0) {
            return false;
        }

        // Save
        repository.save(order);

        // Notify
        notificationServices.stream()
                .filter(service -> service.isApplicable(order))
                .forEach(service -> service.sendOrderConfirmation(order.getId()));

        return true;
    }
}
