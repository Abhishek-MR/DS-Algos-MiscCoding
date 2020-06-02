package com.example.testprogs.algos.platforms.leetcode;

//Given int num, find compliment, a compliment is in binary if 0 then 1 of 1 then 0
//ex 5 -> 2
// 101 -> 010
public class LCNumberCompliment {

    public static void main(String[] args) {
        int num = 5;
        LCNumberCompliment compliment = new LCNumberCompliment();
        System.out.println(compliment.solve(num));
    }

    private int solve(int num) {
        int ans = 0;
        int count = 0;
        while (num > 0) {
            if((num & 1) == 0) { // if that bit pos is 0
                //put 1 in that place by xor
                ans ^= 1<<count;
            }
            num = num>>1;
            count++;
        }
        return ans;
    }
}
