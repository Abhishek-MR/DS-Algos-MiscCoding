package com.example.testprogs.algos.platforms.algodaily;

public class SumDigitUntilOne {

    public int solve(int a) {
        int ans = a ;
        while(ans>9) {
            int sum = 0;
            char[] nos = String.valueOf(ans).toCharArray();
            for (char c:nos) {
                sum += Integer.valueOf(String.valueOf(c));
            }
            ans=sum;
        }
        return ans;
    }
    public static void main(String[] args) {
        SumDigitUntilOne sumDigitUntilOne = new SumDigitUntilOne();
        System.out.println(sumDigitUntilOne.solve(4354));
    }
}
