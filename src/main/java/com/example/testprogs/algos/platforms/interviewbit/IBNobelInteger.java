package com.example.testprogs.algos.platforms.interviewbit;

import java.util.Arrays;

public class IBNobelInteger {

    public int solve(int[] A) {
        Arrays.sort(A);

        for (int i=0; i<A.length ;) {
            int num = A[i];
            int j = i+1;
            while(j<A.length && A[j]==num) {
                j++;
            }
            int greater = A.length - j;
            if(greater == num) {
                return 1;
            }
            i = j;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{ -4, -2, 0, -1, -6 };
        IBNobelInteger ibNobelInteger = new IBNobelInteger();
        System.out.println(ibNobelInteger.solve(A));
    }
}
