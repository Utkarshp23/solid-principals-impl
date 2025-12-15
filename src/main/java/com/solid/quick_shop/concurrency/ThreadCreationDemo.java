package com.solid.quick_shop.concurrency;

public class ThreadCreationDemo {

    public static void main(String[] args) {
        

        Counter counter1 = new Counter();

        Runnable task = ()->{
            for (int i = 0; i < 10000; i++)
                counter1.increment();
        };

        Runnable task2 =   ()->{
            for (int i = 0; i < 10000; i++)
                counter1.increment();
        };


        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter1.increment();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter1.getCount());

    }
}
