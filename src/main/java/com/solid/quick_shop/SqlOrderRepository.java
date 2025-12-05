package com.solid.quick_shop;

public class SqlOrderRepository implements UpdateOrderRepository {

    @Override
    public void save(Order order) {
        // Logic to save order to SQL database
        System.out.println("Order with id " + order.getId() + " saved to SQL database.");
    }

    @Override
    public Order findById(long orderId) {
        // Logic to find order by id from SQL database
        System.out.println("Order with id " + orderId + " retrieved from SQL database.");
        return new Order(orderId, 500, "Sample Order"); // Example order
    }

}
