package com.example.testprogs.algos.algos.dp;

import java.util.Arrays;

public class KnapsackRecursive {

    //memoization
    int[][] dp;
    static int ctr = 0;

    public int computeKnapsack(int[] v, int[] w, int W) {
        ctr = 0;
        dp = new int[v.length+1][W+1];
        for (int[] row: dp)
            Arrays.fill(row, -1);
        return solve(v,w,W,v.length);
    }

    public int solve(int[] v, int[] w, int W, int n) {
        ctr++;
        //base case
        if( n == 0 || W == 0) {
            return dp[n][W] = 0;
        }
        if(dp[n][W]!=-1) {
            return dp[n][W];
        }
        //Options
        //1 Either include or not in knapsack if room present
        // 2 dont include as room not present
        if(w[n-1] <= W) {
            int include = v[n-1]+solve(v,w,W-w[n-1],n-1);
            int exclude = solve(v,w,W,n-1);
            return dp[n][W] = Math.max(include,exclude);
        }
        else {
            return dp[n][W] = solve(v,w,W,n-1);
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{ 4, 6 ,5 ,7, 5, 6 };
        int[] weights= new int[]{ 2, 6 ,6 ,4, 7, 4 };
        int knapsack_wt = 10;

        KnapsackRecursive knapsack = new KnapsackRecursive();
        int maxVal = knapsack.computeKnapsack(values,weights,knapsack_wt);
        System.out.println("Max value is "+maxVal);
        System.out.println("Count "+ctr);
    }
}
