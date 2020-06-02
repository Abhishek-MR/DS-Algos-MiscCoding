package com.example.testprogs.algos.ds.stacks;

import java.util.Stack;

public class MaximumAreaHistogram {


    /*  6           6
        _   5   5   _
    *  | |  _ 4 _  | |
    *  | | | |_| | | |
    *  | |2| | | | | |
    *  | |_| | | |1| |
    *  | | | | | |_| |
    *  | | | | | | | |
    * */

    public int solve(int[] arr) {
        int area = 0;
        int[] nsl = new int[arr.length];
        int[] nsr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                nsl[i] = -1;
            }else {
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
                if(stack.isEmpty()) {
                    nsl[i] = -1;
                }
                else {
                    nsl[i] = stack.peek();
                }
            }
            stack.add(i);
        }

        stack.removeAllElements();

        for (int i = arr.length-1; i >= 0; i--) {
            if(stack.isEmpty()) {
                nsr[i] = arr.length;
            }else {
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
                if(stack.isEmpty()) {
                    nsr[i] = arr.length;
                }
                else {
                    nsr[i] = stack.peek();
                }
            }
            stack.add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int nslv = nsl[i];
            int nsrv = nsr[i];
            System.out.println("nsl"+nslv);
            System.out.println("nsr"+nsrv);
            System.out.println("arr"+arr[i]);
            int val = nsr[i]-1-nsl[i];
            System.out.println("val"+val);
            area = Math.max(area,val*arr[i]);
            System.out.println("area"+area+"\n");

        }

        return area;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,2,5,4,5,1,6};
        MaximumAreaHistogram maximumAreaHistogram = new MaximumAreaHistogram();
        System.out.println(maximumAreaHistogram.solve(arr));
    }
}
