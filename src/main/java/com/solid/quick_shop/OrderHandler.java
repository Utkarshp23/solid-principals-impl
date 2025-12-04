package com.solid.quick_shop;

import java.util.List;

public class OrderHandler {

    private final OrderRepository orderRepository;
    private final List<NotificationService> notificationServices;

    public OrderHandler(OrderRepository orderRepository, List<NotificationService> notificationServices) {
        this.orderRepository = orderRepository;
        this.notificationServices = notificationServices;
    }

    public boolean process(Order order){
        // Validate
        if (order.getOrderTotal()<0) {
            return false;
        }

        // Save
        orderRepository.save(order);

        // Notify
        notificationServices.stream()
                .filter(service -> service.isApplicable(order))
                .forEach(service -> service.sendOrderConfirmation(order.getId()));

        return true;
    }
}
