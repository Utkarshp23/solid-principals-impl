package com.solid.quick_shop.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagramDemo {

    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String sorted = Stream.of(strs[i].split("")).sorted().collect(Collectors.joining());
            if (map.containsKey(sorted)) {
                map.get(sorted).add(strs[i]);
            } else {
                map.put(sorted, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }

        List<List<String>> answer = map.values().stream().collect(Collectors.toList());

        return answer;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

        // Output: [1,2]
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i : nums) {
            if (!map.containsKey(i))
                map.put(i, 0);
            map.put(i, map.get(i) + 1);
        }

        System.out.println("Map:"+map);

        Map<Integer, Integer> treMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            treMap.put(entry.getValue(), entry.getKey());
        }

        System.out.println("TreeMap:"+treMap);

        int i = 0;
        int[] answer = new int[k];

        for (Map.Entry<Integer, Integer> entry : treMap.entrySet()) {
            if (i >= k)
                break;
            answer[i] = entry.getValue();
        }

        return answer;
    }

    public static void main(String[] args) {
        // String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // System.out.println(groupAnagrams(input));

        int [] nums = new int[]{1,2,1,2,1,2,3,1,3,2};
        int k =2; 

        int [] ans = topKFrequent(nums, k);

        for (int s : ans) {
            System.out.println(s);
        }
    }
}
