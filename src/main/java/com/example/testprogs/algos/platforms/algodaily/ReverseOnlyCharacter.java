package com.example.testprogs.algos.platforms.algodaily;

public class ReverseOnlyCharacter {

    public static void main(String[] args) {
        ReverseOnlyCharacter reverseOnlyCharacter = new ReverseOnlyCharacter();
        System.out.println(reverseOnlyCharacter.solve("sea!!$hells&"));
    }

    private String solve(String s) {

        char[] chars = s.toCharArray();
        int first = 0;
        int last = chars.length-1;

        while(first<last) {
            boolean isfirstAlpha = Character.isAlphabetic(chars[first]);
            boolean islastAlpha = Character.isAlphabetic(chars[last]);
            if(isfirstAlpha && islastAlpha) {
                char temp = chars[first];
                chars[first] = chars[last];
                chars[last] = temp;
                first++;
                last--;
            }else {
                if(!isfirstAlpha) {
                    first++;
                }
                if(!islastAlpha) {
                    last--;
                }
            }
        }
        return new String(chars);
    }
}
