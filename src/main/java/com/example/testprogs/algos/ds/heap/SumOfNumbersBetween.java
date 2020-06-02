package com.example.testprogs.algos.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfNumbersBetween {

    public int solve (int k1, int k2, int[] arr) {
        int sum = 0;
        //getting the index
        k1 = k1-1;
        k2 = k2-1;
        int tempMin = Math.min(k1,k2);
        int tempMax = Math.max(k1,k2);
        k1 = tempMin;
        k2 = tempMax;

        //lets make max heap as we need to get smallest numbers
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1; // as we need max or ( - (o1 - o2) )
            }
        });

        for(Integer i : arr) {
            maxHeap.add(i);
            if(maxHeap.size() > k2) {
                maxHeap.poll();
            }
        }

        for (int i = 0; i < k2; i++) {
            if(i > k1 && maxHeap.size()>0) {
                sum+=maxHeap.poll();
            }
        }

        return sum;
    }
    public static void main(String[] args) {

        //find the sum between the 3rd and 6th smallest number
        //i.e betweem 5 and 15 when you sort [1,3,5,11,12,15]
        int[] data = new int[]{1,3,12,5,15,11};
        int k1 = 3;
        int k2 = 6;
        SumOfNumbersBetween sumOfNumbersBetween = new SumOfNumbersBetween();
        int sum = sumOfNumbersBetween.solve(k1,k2,data);
        System.out.println(sum);
    }
}
