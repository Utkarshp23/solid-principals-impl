package com.solid.quick_shop.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", 70000, "HR"),
                new Employee("Bob", 80000, "Finance"),
                new Employee("Charlie", 90000, "IT"),
                new Employee("David", 60000, "HR"),
                new Employee("Eve", 95000, "Finance")
        );

        employees.stream()
            .filter(e->e.getDepartment().equalsIgnoreCase("IT"))
            .forEach(e -> System.out.println(e.getName()));

        List<String> eNames = employees.stream()
                                    .filter(e->e.getSalary()>70000)
                                    .map(e -> e.getName().toUpperCase())
                                    .collect(Collectors.toList());
        System.out.println("eNames:"+eNames);

        Map<String, List<Employee>> map = employees.stream()
                                            .collect(Collectors.groupingBy(e->e.getDepartment()));

         System.out.println("map:"+map);   


    }
}
