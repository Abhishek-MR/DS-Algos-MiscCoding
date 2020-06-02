package com.example.testprogs.algos.competitions.dream11;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question4 {

    public int solution(int[] expenditure, int d) {

        int count = 0;
        for(int i=d; i<expenditure.length;i++) {
            int l = i-d;
            int r = i;

            PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            for (int j = l; j < r; j++) {
                heap.add(expenditure[j]);
                if(heap.size()>(d/2)+1) heap.poll();
            }
            float med = (d%2==0)?((float)(heap.poll()+heap.poll()))/2 : heap.poll();
            if(expenditure[i]>=2*med) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
        int[] arr = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int d = 5;

        Question4 question1 = new Question4();
        System.out.println(question1.solution(arr,d));
    }
}
