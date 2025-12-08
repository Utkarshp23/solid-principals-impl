package com.solid.quick_shop.lambda;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapLevel5 {

    public static void main(String[] args) {

        // Level 5 : exercise: 1
        // List<List<Integer>> numbers = List.of(
        //         List.of(1, 2, 3),
        //         List.of(4, 5),
        //         List.of(6, 7, 8, 9));

        // List<Integer>  flattnedNumbers = numbers.stream()
        //                                     .flatMap(list ->list.stream())
        //                                     .map(n->n*10)
        //                                     .collect(Collectors.toList());
        // System.out.println("FlatteneNumbers: "+ flattnedNumbers);


        // Level 5 : exercise: 1
        //String test="";
        //Optional<String> opt1 = Optional.of("test");
        //Optional<String> opt2 = Optional.ofNullable(test);

        // Optional<String> maybeName = Optional.of("utkarsh");

        // Optional<String> output = maybeName.map(String::toUpperCase).filter(s->s.length()>4).orElse("To Short");

        int[] nums = {1,2,3,4};
        int len = nums.length;

        int[] prefix = new int[len];

        int[] suffix = new int[len];

        
        int curMulSu=1;
        int curMulPr=1;
        for(int i=0;i<len;i++){
            curMulPr = nums[i]*curMulPr;
            prefix[i]=curMulPr;

            curMulSu = nums[len-i-1]*curMulSu;
            suffix[len-i-1]=curMulSu;
        }

        int [] ans = new int[len];

        for (int i = 0; i < len; i++) {
            if(i==0){
                ans[i]=suffix[i+1];
            } else if(i==len-1){
                ans[i]=prefix[i-1];
            } else{
                 ans[i]=prefix[i-1]*suffix[i+1];
            }
        }

        // return ans;

    }
}
