package com.example.testprogs.algos.platforms.misc;

import java.util.HashSet;

public class BalloonArrow {

    public int count (int [] A) {
        int count = 0;
        HashSet<Integer> arrows = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            int arrow_len = A[i];
            if(arrows.contains(arrow_len)) {
                arrows.remove(arrow_len);
            }
            else {
                count++;
            }
            arrows.add(arrow_len-1);
        }

        return count;
    }
    public static void main(String[] args) {
        int[] A = new int[]{6,5,2,4,5};
        System.out.println(new BalloonArrow().count(A));
    }
}
