package com.example.testprogs.algos.competitions.dream11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question1 {

    public int solution(List<Integer> arr) {
        if(arr.size() == 0) return 0;
        if(arr.size() == 1) return 1;

        Collections.sort(arr);
        System.out.println(arr);

        int prev = 1;

        for(int i=1;i<arr.size();i++) {
            if(arr.get(i)>prev) {
                prev = prev+1;
            }
        }

        return prev;
    }

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        arr.add(324324);

        Question1 question1 = new Question1();
        System.out.println(question1.solution(arr));
    }
}
