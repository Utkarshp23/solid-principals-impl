package com.solid.quick_shop.lambda;

@FunctionalInterface
public interface TriFunction<A,B,C,R> {
    R apply(A a, B b, C c);
}
