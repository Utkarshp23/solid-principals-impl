package com.solid.quick_shop.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaLevel4_MethodRefs {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("utkarsh", "amit", "pawan", "zed");

        // Level 4: exercise 1
        names.stream()
            .forEach(System.out::println);

        List<String> output1 = names.stream()
                                    .map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(output1);

        List<String> output2 = names.stream()
                                    .sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        System.out.println(output2);

        BiFunction<Integer,Integer,Integer> adder =  Calculator::add;
        System.out.println("Custem method referece Adder:"+adder.apply(56, 45));

        Calculator calc = new Calculator();
        BiFunction<Integer,Integer,Integer> multiplier =  calc::multiply;
        System.out.println("Custem method referece Multiplier:"+multiplier.apply(56, 45));


        // Level 4: exercise 2
        PersonFactory pf = Person::new;
        List<Person> personsList = names.stream()
                                        .map(a->pf.create(a, a.length()))
                                        .collect(Collectors.toList());
        System.out.println("PersonList:"+personsList);

        // Level 4: exercise 3
        
    }
}
