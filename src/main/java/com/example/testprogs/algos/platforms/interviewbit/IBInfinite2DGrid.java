package com.example.testprogs.algos.platforms.interviewbit;

public class IBInfinite2DGrid {

    /*
    You are given a sequence of points and the order in which you need to cover the points.
    Give the minimum number of steps in which you can achieve it. You start from the first point.

    Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.

    Return an Integer, i.e minimum number of steps.

    Input : [(0, 0), (1, 1), (1, 2)]
    Output : 2

    It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
    */

    public int coverPoints(int[] A, int[] B) {
        if(A.length == 1) return 0;

        int sum = 0;

        for( int i = 1; i<A.length ; ++i) {
            int xval = Math.abs(A[i] - A[i-1]);
            int yval = Math.abs(B[i] - B[i-1]);
            sum += Math.min(xval, yval) + Math.abs(xval - yval);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] A = new int[] {0,1,1};
        int[] B = new int[] {0,1,2};

        IBInfinite2DGrid ib = new IBInfinite2DGrid();
        System.out.println(ib.coverPoints(A,B));
    }
}
