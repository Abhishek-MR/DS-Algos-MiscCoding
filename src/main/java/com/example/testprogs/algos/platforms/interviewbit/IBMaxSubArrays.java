package com.example.testprogs.algos.platforms.interviewbit;

import java.util.Arrays;

public class IBMaxSubArrays {

    public int sum;
    public int len;
    public int startindex;
    public int[] data;
    public static void main(String[] args) {

        int[] A = new int[] {324,6,54,2,54,765,54};
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
    }
}
