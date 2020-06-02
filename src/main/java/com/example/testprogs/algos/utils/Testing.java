package com.example.testprogs.algos.utils;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Testing {

    public static void main(String[] args) {
        ArrayList<Integer> integers= new ArrayList<>();
        integers.add(32554);
        integers.add(64355);
        integers.add(435);
        integers.add(5264);

        String a = "13";
        String b = "2";
//        System.out.println(a.compareTo(b));
        System.out.println(String.join("",integers.parallelStream().map(String::valueOf).sorted((o1, o2) -> {
            return - (o1+o2).compareTo(o2+o1);
        }).collect(Collectors.toList())));
//        System.out.println(Utils.objToJsonPrettyStr(strings, Logger.getGlobal()));

        PriorityQueue<Integer> heap1 = new PriorityQueue<>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<>(((o1, o2) -> -(o1 - o2)));

        heap1.add(2);
        heap2.add(2);
        heap1.add(4);
        heap2.add(4);
        heap1.add(1);
        heap2.add(1);

        System.out.println("heap1 "+heap1.peek());
        System.out.println("heap2 "+heap2.peek());
    }
}
