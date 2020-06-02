package com.example.testprogs.algos.platforms.leetcode;

import java.util.Arrays;

public class LeetCodeProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int [] leftProduct = new int[nums.length];

        //first we get left products

        for (int i = 0; i < nums.length; i++) {
            leftProduct[i] = ((i>0)?leftProduct[i-1]:1) * nums[i];
        }

        //we store right product on the go and compute the output
        int rightProduct = 1;

        for (int i = nums.length-1; i >=0 ; i--) {

            leftProduct[i] = (i==0)?rightProduct:rightProduct*leftProduct[i-1];
            rightProduct = ((i<nums.length-1)?rightProduct:1) * nums[i];

        }

        return leftProduct;
    }

    public static void main(String[] args) {
        int[] inp = {2,1,4,16};
        LeetCodeProductExceptSelf productExceptSelf = new LeetCodeProductExceptSelf();
        int[] res  = productExceptSelf.productExceptSelf(inp);
        System.out.println(Arrays.toString(res));
    }
}
