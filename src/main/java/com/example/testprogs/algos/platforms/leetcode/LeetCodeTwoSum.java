package com.example.testprogs.algos.platforms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeTwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> compmap = new HashMap<>();
        for(int i=0;i<nums.length;++i) {
            if(compmap.containsKey(nums[i])) {
                return new int[] {compmap.get(nums[i]) , i};
            }
            compmap.put(target-nums[i],i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15} ,9)));
    }
}
