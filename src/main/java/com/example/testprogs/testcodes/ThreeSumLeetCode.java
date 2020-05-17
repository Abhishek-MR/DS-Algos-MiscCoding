package com.example.testprogs.testcodes;

import com.example.testprogs.utils.Utils;
import sun.rmi.runtime.Log;

import java.util.*;
import java.util.logging.Logger;

public class ThreeSumLeetCode {

    public int[] twosum(int[] nums, int target, int ignore) throws IllegalArgumentException{
        Map<Integer,Integer> compmap = new HashMap<>();
        for(int i=ignore;i<nums.length;++i) {
            if(compmap.containsKey(nums[i]) && compmap.get(nums[i])!=i && compmap.get(nums[i])!=ignore) {
                return new int[] {compmap.get(nums[i]) , i};
            }
            compmap.put(target-nums[i],i);
        }
        throw new IllegalArgumentException();
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++) {
            try{
                int[] two = twosum(nums, -nums[i],i);
                List one = new ArrayList<Integer>();
                one.add(nums[i]);
                one.add(nums[two[0]]);
                one.add(nums[two[1]]);
                res.add(one);
            }catch (Exception e) {e.printStackTrace();}
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumLeetCode t = new ThreeSumLeetCode();
        System.out.println(Utils.objToJsonPrettyStr(t.threeSum(new int[]{-1, 0, 1, 2, -1, -4}), Logger.getGlobal()));
    }
}
