package com.solid.quick_shop.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LambdaLevel4_Async {

    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(3);

        Callable<String> call1 = () ->{
            Thread.sleep(200);
            return "Task 1 Done on thread " + Thread.currentThread();
        };
        Callable<String> call2 = () ->{
            Thread.sleep(400);
            return "Task 2 Done on thread " + Thread.currentThread();
        };
        Callable<String> call3 = () ->{
            Thread.sleep(600);
            return "Task 3 Done on thread " + Thread.currentThread();
        };

        // LambdaUtils.measureTime("Executor-Call", call3);

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(call1);
        callableTasks.add(call2);
        callableTasks.add(call3);

        try {
            List<Future<String>> futures = exe.invokeAll(callableTasks);
            futures.stream().forEach(f -> {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        exe.shutdown();
        
    }
}
