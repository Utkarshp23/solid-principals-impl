package com.solid.quick_shop.lambda;

import java.util.function.Supplier;

public class LambdaUtils {

    public static <T> T measureTime(String label, Supplier<T> action) {
        System.out.println("Starting:" + label);

        long sms = System.currentTimeMillis();
        T output = action.get();

        long ems = System.currentTimeMillis();

        return output;

    }

    static void retry(int times, Runnable action) {
        for (int i = 0; i < times; i++) {
            try {
                action.run();
                return;
            } catch (RuntimeException e) {
                // TODO: handle exception
                continue;
            }
        }
        System.out.println("Retry unsuccessful!!");
    }

    public static void main(String[] args)  {
        
        Supplier<String> suplly = () -> { 
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "Task done";
        };

        measureTime("Targets", suplly);
    }
}
