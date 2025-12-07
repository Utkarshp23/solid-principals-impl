package com.solid.quick_shop.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class LambdaLevel3 {
    public static void main(String[] args) {

        // Level 3: exercise : 1
        List<String> names = Arrays.asList("Utkarsh", "Amit", "Pawan", "Zed", "Ab");
        System.out.println("Before sorting:" + names);

        names.sort(Comparator.comparingInt(String::length).thenComparing(String::compareToIgnoreCase));

        System.out.println("After sorting:" + names);

        // Level 3: exercise : 2
        List<String> words = Arrays.asList("lambda", "bootcamp", "java", "ai", "utkarsh");

        List<String> output = words.stream()
                .filter(name -> name.length() > 4)
                .map(String::toUpperCase)
                .sorted().toList();

        System.out.println("Words after processing: "+ output);

        // Level 3: exercise : 3
        TriFunction<String,String,String,String> processor= (a,b,c)-> a+"-"+b+"-"+c;
        System.out.println("Trifunction: "+processor.apply("Let", "Set", "Go"));

        // Level 3: exercise : 4
        Function <Integer,Integer> times2 = a -> a*2;
        Function<Integer,Integer> plus3 = a -> a+3;

        Function <Integer,Integer> times2ThenPlus3 = times2.andThen(plus3);
        Function <Integer,Integer> plus3ThenTimes2 = plus3.compose(times2);

        System.out.println("times2ThenPlus3: "+times2ThenPlus3.apply(5));
        System.out.println("plus3ThenTimes2: "+ plus3ThenTimes2.apply(5));

        // Level 3: exercise : 5
        try {
            Callable<String> delayedTask = () -> {
                Thread.sleep(500);
                return "Done";
            };
            System.out.println(delayedTask.call());
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }
}
