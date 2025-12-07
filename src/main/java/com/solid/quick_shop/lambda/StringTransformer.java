package com.solid.quick_shop.lambda;

@FunctionalInterface
public interface StringTransformer {
    String transform(String input);
}
