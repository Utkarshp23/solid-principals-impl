package com.solid.quick_shop.d2d;

import com.solid.quick_shop.Order;

public class Test {

    public static void main(String []args){
       
        Order order = new Order();
        Order order2 = order;

        order2.setId(23);

        System.out.println(order);
    }

}
