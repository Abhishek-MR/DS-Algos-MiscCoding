package com.example.testprogs.algos.platforms.algodaily;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public char solve(String inp) {
        Map<Character,Integer> map = new HashMap();
        char res = '\0';

        for(int i=0; i<inp.length() ;i++) {
            if(!map.containsKey(inp.charAt(i))) {
                map.put(inp.charAt(i),0);
            }
            map.put(inp.charAt(i),map.get(inp.charAt(i))+1);
        }

        for(int i=0; i<inp.length() ;i++) {
            if(map.get(inp.charAt(i)) == 1) {
                return inp.charAt(i);
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter f= new FirstNonRepeatingCharacter();
        System.out.println(f.solve("which is the first non repeating char? which is the first non repeating char"));
    }
}
