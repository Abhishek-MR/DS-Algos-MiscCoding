package com.example.testprogs.algos.competitions.dream11;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Question2 {

    public List<Integer> solution(List<String> command) {
        List<Integer> results = new ArrayList<Integer>();
        results.add(0);

        for (int i = 1; i < command.size(); i++) {
            String comparing = command.get(i);
            List<Pair<Integer, Integer>> matches = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                String compared = command.get(j);
                int s1 = comparing.length();
                int s2 = compared.length();
                int lenMatch = 0;
                for (int k = 0, l = 0; k <= s1 - 1 && l <= s2 - 1; k++, l++) {
                    if (comparing.charAt(k) != compared.charAt(l)) {
                        break;
                    } else {
                        lenMatch++;
                    }
                }
                if (lenMatch > 0)
                    matches.add(new Pair<>(j + 1, lenMatch));
            }

            if (matches.size() == 0) {
                results.add(i);
                continue;
            }

            Pair<Integer, Integer> max = new Pair<>(0, 0);
            for (int m = 0; m < matches.size(); m++)
                if (matches.get(m).getValue() > max.getValue())
                    max = matches.get(m);
                else if (matches.get(m).getValue() > max.getValue())
                    if (matches.get(m).getKey() > max.getKey())
                        max = matches.get(m);

            results.add(max.getKey());
        }
        return results;
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

        Question2 question1 = new Question2();
        System.out.println(question1.solution(arr));
    }
}
