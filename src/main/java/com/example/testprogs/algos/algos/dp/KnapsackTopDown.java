package com.example.testprogs.algos.algos.dp;

public class KnapsackTopDown {

    public int computeKnapsack(int[] v, int[] w, int W) {
        int[][] dp = new int[v.length+1][W+1];
        int n = v.length;

        //Matrix initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1 ; j++) {
                if(w[i-1] <= j) {
                    int include = v[i-1] + dp[i-1][j-w[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }


    public static void main(String[] args) {
        int[] values = new int[]{ 4, 6 ,5 ,7, 5, 6 };
        int[] weights= new int[]{ 2, 6 ,6 ,4, 7, 4 };
        int knapsack_wt = 10;

        KnapsackTopDown knapsack = new KnapsackTopDown();
        int maxVal = knapsack.computeKnapsack(values,weights,knapsack_wt);
        System.out.println("Max value is "+maxVal);
    }
}
