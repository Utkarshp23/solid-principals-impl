package com.solid.quick_shop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile implements OrderRepository {

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

}
