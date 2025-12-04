package com.solid.quick_shop;

public class EmailSender implements NotificationService, NewsletterService {

    @Override
    public void sendOrderConfirmation(long orderId) {
        // Logic to send email
        System.out.println("Email sent for order id: " + orderId);
        sendNewsletter(orderId);
    }

    @Override
    public boolean isApplicable(Order order) {
        // Logic to determine if email notification is applicable
        return order.getOrderTotal() <= 1000;
    }

    @Override
    public void sendNewsletter(long userId) {
        // Logic to send newsletter email
        System.out.println("Newsletter email sent to user id: " + userId);
    }
}
