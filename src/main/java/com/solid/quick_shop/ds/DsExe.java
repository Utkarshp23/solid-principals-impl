package com.solid.quick_shop.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DsExe {

    public static boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        // Using  hashmap : 1
        // Map<Integer, Integer> map = new HashMap<>();

        // for (int i : nums) {
        //     if (map.containsKey(i)) {
        //         return true;
        //     } else {
        //         map.put(i, 1);
        //     }
        // }

        // return false;

        //Using HashSet
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,1};
        System.out.println(containsDuplicate(nums));
    }

}
