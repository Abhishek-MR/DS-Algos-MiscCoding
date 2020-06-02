package com.example.testprogs.algos.competitions.dream11;

import java.util.ArrayList;
import java.util.List;

public class Question3 {

    public int solution(String s, String t) {

        int res = 0;

        if(t.length() == s.length()) {
            if(!t.equals(s))
                return -1;
        }
        else if(t.length() > s.length()/2) return -1;
        else {
            int s1 = s.length();
            int s2 = t.length();

            if(s1%s2!=0) return -1;

            int mulFact = s1/s2;

            int lenMatch = 0;
            for (int i=0; i<s2; i++) {
                for(int j=0; j<mulFact; j++) {
                    int k = i+(j*s2);
                    if (t.charAt(i) != s.charAt(k)) {
                        break;
                    } else {
                        lenMatch++;
                    }
                }
            }

            if(lenMatch/mulFact == s2) {
                if (s2 < 2) {
                    return 1;
                }

                StringBuilder substr = new StringBuilder();
                for (int i = 0; i < s2 / 2; i++) {
                    substr.append(t.charAt(i));

                    String cleared
                            = t.replaceAll(substr.toString(), "");

                    if (cleared.length() == 0) {
                        return cleared.length();
                    }
                }

                return -1;

            }else {
                return -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
        List<String> arr = new ArrayList<>();
        arr.add("000");
        arr.add("1110");
        arr.add("01");
        arr.add("001");
        arr.add("110");
        arr.add("11");

        Question3 question1 = new Question3();
        System.out.println(question1.solution("ababab","ab"));
    }
}
