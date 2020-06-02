package com.example.testprogs.algos.algos.dp;

public class SubsetSumProblem {

    public boolean solve(int[] arr, int sum) {
        boolean result = false;

        boolean[][] dp = new boolean[arr.length+1][sum+1];

        //base case
        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;
            }
        }

        //choice diagram
        for (int i = 1; i < arr.length+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                boolean ans;
                if(arr[i-1] <= j) {
                    boolean include = dp[i][j-arr[i-1]];
                    boolean exclude = dp[i-1][j];
                    ans = include | exclude;
                }
                else {
                    boolean exclude = dp[i-1][j];
                    ans = exclude;
                }
                dp[i][j] = ans;
            }
        }

        return dp[arr.length][sum];

    }

    public static void main(String[] args) {
        int arr[] = {2,3,7,8,10};
        int sum = 11;

        System.out.println(new SubsetSumProblem().solve(arr,sum));
    }
}
