package com.example.testprogs.algos.platforms.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IBHammingDistance {

    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public int solve(final List<Integer> A) {
        int solution = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                int num = A.get(i) ^ A.get(j);
                if(map.containsKey(num)){
                    solution+=map.get(num);
                }else {
                    int count= countSetBits(num);
                    map.put(num,count);
                    solution+=count;
                }
                solution%=1000000007;
            }
        }

        return solution;
    }
    public static void main(String[] args) {
        IBHammingDistance hammingDistance = new IBHammingDistance();

        List<Integer> A = new ArrayList<>();
        A.add(88);
        A.add(5);
        A.add(47);
        A.add(88);
        A.add(60);
        A.add(23);
        System.out.println(hammingDistance.solve(A));

    }
}
