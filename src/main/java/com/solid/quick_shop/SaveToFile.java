package com.solid.quick_shop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile implements UpdateOrderRepository {

    @Override
    public void save(Order order) {
        // Save order to file
        try (FileWriter fileWriter = new FileWriter("orders.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(order.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order findById(long orderId) {
        // Logic to find order by id from file (not implemented here)
        return null; // Placeholder return
    }

}
