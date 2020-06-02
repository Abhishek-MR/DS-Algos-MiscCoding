package com.example.testprogs.algos.platforms.interviewbit;

import java.util.ArrayList;

public class IBPrettyPrint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int size = A;
        int[][] pattern = new int[2*A-1][2*A-1];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int N = 2 * A - 2;
        int j = 0;
        while (A > 0) {
            for (int i = j; i < N + 1; i++) {
                pattern[i][j] = A;
                pattern[j][i] = A;
                pattern[N][i] = A;
                pattern[i][N] = A;
            }
            A--;
            N--;
            j++;
        }

        for (int i = 0; i <2*size-1 ; i++) {

            ArrayList<Integer> list = new ArrayList<>();
            for (int k = 0; k <2*size-1 ; k++) {
                list.add(pattern[i][k]);
            }
            arr.add(list);
        }

        return arr;
    }

    static void print(ArrayList<ArrayList<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                System.out.print(A.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        print(new IBPrettyPrint().prettyPrint(4));
    }
}
