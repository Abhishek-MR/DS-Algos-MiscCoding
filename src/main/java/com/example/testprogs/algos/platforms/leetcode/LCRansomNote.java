package com.example.testprogs.algos.platforms.leetcode;

import java.util.HashMap;

//Given string of a ransomnote to be created from a string of magazine
// op - boolean of can be created
public class LCRansomNote {



    public static void main(String[] args) {
        String ransomenote = "ab";
        String magazin = "abb";

        LCRansomNote ransomNote = new LCRansomNote();
        System.out.println(ransomNote.solve(ransomenote,magazin));
    }

    private boolean solve(String r, String m) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < m.length(); i++) {
            if(!map.containsKey(m.charAt(i)))
                map.put(m.charAt(i),0);
            map.put(m.charAt(i),map.get(m.charAt(i))+1);
        }

        for (int i = 0; i < r.length(); i++) {
            if(map.containsKey(r.charAt(i))) {
                map.put(r.charAt(i),map.get(r.charAt(i))-1);
            }else return false;
        }

        return true;
    }
}
