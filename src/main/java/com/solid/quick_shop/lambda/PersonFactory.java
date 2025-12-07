package com.solid.quick_shop.lambda;

@FunctionalInterface
public interface PersonFactory {
     Person create(String name, int age);
}
