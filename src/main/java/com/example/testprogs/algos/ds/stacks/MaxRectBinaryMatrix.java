package com.example.testprogs.algos.ds.stacks;

import java.util.Arrays;

public class MaxRectBinaryMatrix {

    public int solve (int[][] arr,int n, int m) {
        int res = 0;
        MaximumAreaHistogram maximumAreaHistogram = new MaximumAreaHistogram();
        int[] data = new int[m];
        Arrays.fill(data,0);

        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                int val = arr[i][j];
                if(val == 0) {
                    data[j] = 0;
                }
                else {
                    data[j] += val;
                }
            }
            res = Math.max(res,maximumAreaHistogram.solve(data));
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] data = new int[][]{
                {
                        0, 1, 1, 0
                },
                {
                        1, 1, 1, 1
                },
                {
                        1, 1, 1, 1
                },
                {
                        1, 1, 0, 0
                }
        };

        MaxRectBinaryMatrix maxRectBinaryMatrix = new MaxRectBinaryMatrix();
        System.out.println(maxRectBinaryMatrix.solve(data,4,4));
    }
}
