package com.example.testprogs.algos.algos.dp;

public class CountOfSubsetsWithGivenSum {

    public int solve(int[] arr, int sum) {

        int[][] dp = new int[arr.length+1][sum+1];

        //base case
        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i == 0) dp[i][j] = 0;
                if(j == 0) dp[i][j] = 1;
            }
        }

        //choice diagram
        for (int i = 1; i < arr.length+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                int ans;
                if(arr[i-1] <= j) {
                    int include = dp[i][j-arr[i-1]];
                    int exclude = dp[i-1][j];
                    ans = include + exclude;
                }
                else {
                    int exclude = dp[i-1][j];
                    ans = exclude;
                }
                dp[i][j] = ans;
            }
        }

        return dp[arr.length][sum];

    }

    public static void main(String[] args) {
        int arr[] = {2,3,5,6,8,10};
        int sum = 10;

        System.out.println(new CountOfSubsetsWithGivenSum().solve(arr,sum));
    }
}
