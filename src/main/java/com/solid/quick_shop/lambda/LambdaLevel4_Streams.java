package com.solid.quick_shop.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaLevel4_Streams {
    public static void main(String[] args) {
        // List of Persons
        List<Person> persons = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Jack", 35),
                new Person("Doe", 15),
                new Person("Sparrow", 18),
                new Person("Nano", 10));

        List<String> names = persons.stream()
                .filter(p -> p.getAge() >= 18)
                .map(p -> p.getName()).collect(Collectors.toList());

        System.out.println("Names: "+ names);

        Map<String, List<Person>> output = persons.stream()
                .collect(Collectors.groupingBy(p -> p.getAge() >= 18 ? "ADULD" : "MINOR"));

        System.out.println("Classified:"+output);

    }
}
