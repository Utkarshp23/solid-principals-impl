package com.solid.quick_shop.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DsExe {

    //
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

     public static boolean isAnagram(String s, String t) {
        int len = s.length();
        int len2 = t.length();
        if(len!=len2) return false;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i <len;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        for (int i =0; i<len2;i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i))-1);
            }else{
                return false;
            }
        }
        for(Map.Entry<Character,Integer> etr: map.entrySet()){
            if (etr.getValue()!=0) {
                return false;
            }
        }
        return true;
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            System.out.println(map);
            if(map.containsKey(target-nums[i])){
                return new int[]{ map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
            
        }

        return new int[2];
    }

    public static void main(String[] args) {
        // int [] nums = {1,2,3,4,1};
        // System.out.println(containsDuplicate(nums));

        // String s = "aacc";
        // String t = "ccac";
        // System.out.println(isAnagram(s, t));
        int [] nums = {2,7,11,15};
        int target =9;
        int []ans = twoSum(nums, target);
        System.out.println(ans[0]+":"+ans[1]);
    }

}
