package com.solid.quick_shop.d2d;

import com.solid.quick_shop.Order;

public class Test {

    public static void main(String []args){
       
        // Order order = new Order();
        // Order order2 = order;

        // order2.setId(23);

        // System.out.println(order);

        int [] arr = {1,2};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int i =0;
        int j = i+1;

        int maxProfit = 0 ;


        while (i<(prices.length-1) && j<prices.length) {

            if(j==prices.length-1){
                i++;
                
                j=i+1;
            }
            
            if(prices[j]-prices[i]>maxProfit){
                maxProfit = prices[j]-prices[i];
            }

            j++;
        }

        return maxProfit;
    }

}
