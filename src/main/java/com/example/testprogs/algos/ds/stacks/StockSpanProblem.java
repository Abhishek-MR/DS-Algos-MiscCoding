package com.example.testprogs.algos.ds.stacks;

import java.util.Arrays;
import java.util.Stack;


//In given array of stock prices in a day,
// need to output the number of consecutive smaller or equal prices before it including it

public class StockSpanProblem {


    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        StockSpanProblem stockSpanProblem = new StockSpanProblem();
        System.out.println(Arrays.toString(stockSpanProblem.solve(arr)));
    }

    private int[] solve(int[] arr) {
        int[] res = new int[arr.length];
        int[] nglIndex = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                nglIndex[i] = -1;
            }
            else {
                while(!stack.isEmpty() && (arr[stack.peek()] <= arr[i])) stack.pop();
                if(stack.isEmpty()) {
                    nglIndex[i] = -1;
                }
                else {
                    nglIndex[i] = stack.peek();
                }
            }
            stack.add(i);
        }
        for (int i = 0; i < nglIndex.length; i++) {
            res[i] = i-nglIndex[i];
        }

        return res;
    }
}
