package com.solid.quick_shop.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLevel2 {

    public static void main(String[] args) {
        // Level 2 : exersise : 1
        // Custom Functional interface
        StringTransformer upperCaseTransformer = new StringTransformer() {
            @Override
            public String transform(String input){
                return input.toUpperCase();
            }
        };
        System.out.println("StringTransformer Using Annonymous class:"+upperCaseTransformer.transform("bootcamp"));

        StringTransformer reverseTransformer = (a)->{ 
            StringBuilder stringBuilder = new StringBuilder(a);
            return stringBuilder.reverse().toString();
        };
        System.out.println("StringTransformer Using Lambda:"+ reverseTransformer.transform("lambda"));

        // Level 2 : exersise : 2
        IntOperation safeDivide = (a,b)->{
            System.out.println("First Number:"+a+"|Second Number:"+b);
            if(b==0) return -1;
            return a/b;
        };
        System.out.println("SafeDivid:"+safeDivide.operate(4,2));

        // Level 2 : exersise : 3
        int factor = 10;
        Function<Integer,Integer> multiplyFactor = x -> x *factor;
        // factor =20;

        // Level 2 : exersise : 4
        Predicate<String> checkString = s-> s.length()>5;
        Function<String, Integer> stringMapper = s->s.length();
        Consumer<Integer> stringLength = s -> System.out.println("Length is:"+s);

        String input = "BootCamp!";
        if(checkString.test(input)){
            stringLength.accept(stringMapper.apply(input));
        }
    }
}
