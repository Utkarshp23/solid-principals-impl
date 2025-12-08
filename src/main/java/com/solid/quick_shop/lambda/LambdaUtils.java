package com.solid.quick_shop.lambda;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class LambdaUtils {

    public static <T> T measureTime(String label, Supplier<T> action) {
        System.out.println("Starting:" + label);

        long sms = System.currentTimeMillis();
        T output = action.get();

        long ems = System.currentTimeMillis();
        System.out.println("Finished: "+label + " in "+ (ems-sms) +" ms");
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


        AtomicInteger counter = new AtomicInteger(0);
        Runnable r = ()->{
            int attempt = counter.incrementAndGet();
            if(attempt<=2) {
                throw new RuntimeException();
            }
            System.out.println("Run successful!!");
           
        };

        retry(3, r);
    }
}
