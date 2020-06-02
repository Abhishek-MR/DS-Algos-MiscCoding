package com.example.testprogs.algos.ds.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeft {

    private int[] find(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(stack.empty()) {
                res[i] = -1;
                stack.push(num);
            }
            else if (stack.peek() > num) {
                res[i] = stack.peek();
                stack.push(num);
            }
            else if (stack.peek() < num) {
                while(!stack.empty() && stack.peek()<num) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    res[i] = -1;
                }else {
                    res[i] = stack.peek();
                }
                stack.push(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,4};
        NearestGreaterToLeft nearestGreaterToLeft = new NearestGreaterToLeft();
        int[] sol= nearestGreaterToLeft.find(arr);
        System.out.println(Arrays.toString(sol));
    }


}
