package com.solid.quick_shop.lambda;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaLevel1 {

    public static void main(String[] args) throws Exception {

        // Level 1 : 
        // 1. 
        // Functinal interface having only one abstract method
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from Runnablem using Anonymous Class");
            }
        };
        r.run();

        Runnable r1 = () -> System.out.println("Hello from Runnable using Lambda");
        r1.run();


        // 2. 
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        };
        System.out.println("Comparator from Annonymous class:" + c.compare("Utkarsh", "UtkarshPawar"));

        Comparator<String> c1 = (s1, s2) -> s1.length() - s2.length();
        System.out.println("Comparator from Lambda function:" + c1.compare("Utkarsh", "UtkarshPawar"));


        //3. 
        Callable<Integer> call = new Callable<Integer>() {
            public Integer call() {
                return 42;
            }
        };

        System.out.println("Callable Annonymous call:"+call.call());

        Callable<Integer> call2 = ()-> 42;
        System.out.println("Callable lambda call:"+ call2.call());

        //4.
         //(a) -> a*a;
         Function<Integer,Integer> square = a ->a*a;
         System.out.println("Square:"+square.apply(5));

         //5. 
         //(a,b) -> a+b;
         BinaryOperator<Integer> add = (a,b) -> a+b;
         System.out.println("Add:"+add.apply(56, 56));

         //6.
         //() -> "Bootcamp!"
        Supplier<String> supply = ()->"Bootcamp!";
        System.out.println("Supply:"+supply.get());
    }
}
