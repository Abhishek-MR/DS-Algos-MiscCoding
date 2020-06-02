package com.example.testprogs.algos.platforms.leetcode;

import java.util.HashSet;
import java.util.Set;

//Given string J of distinct chars as jewels and S all chars as stones present with you, find how many jewels you have
//example J = aA
// S = "aAAbbbb"
//op - 3 i.e aAA
public class LCJewelsAndStones {



    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        LCJewelsAndStones jewelsAndStones = new LCJewelsAndStones();
        System.out.println(jewelsAndStones.solve(J,S));
    }

    private int solve(String j, String s) {
        int count = 0;

        //using set to store and check distinct elements
        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < j.length(); i++) {
            jewels.add(j.charAt(i));
        }

        for (int i = 0; i <s.length(); i++) {
            if(jewels.contains(s.charAt(i)))count++;
        }

        return count;
    }
}
