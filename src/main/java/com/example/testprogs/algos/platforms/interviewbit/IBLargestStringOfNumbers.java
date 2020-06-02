package com.example.testprogs.algos.platforms.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IBLargestStringOfNumbers {
    public String largestNumber(final int[] A) {
            List<Integer> l = new ArrayList();
            for( int a : A) {
                l.add(a);
            }

            return (Collections.frequency(l, 0) == l.size()) ? "0" :String.join("", l.parallelStream().map(String::valueOf).sorted((a, b) -> -( a + b).compareTo(b + a)).collect(Collectors.toList()));
    }

    public static void main(String[] args) {

    }
}
