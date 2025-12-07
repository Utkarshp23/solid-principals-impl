package com.solid.quick_shop.lambda;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name =name;
        this.age =age;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Person: [name:"+name+",age:"+age+"]";
    }
}
