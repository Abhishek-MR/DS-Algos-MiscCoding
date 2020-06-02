package com.example.testprogs.algos.algos.sorting;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter n");
        int n = s.nextInt();
        System.out.println("Enter "+n+" elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=s.nextInt();
        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(a);
        System.out.println("Sorted");
        for (int i: a) {
            System.out.print(i+"\t");
        }
    }

    public void sort(int[] a) {
        for (int i = 0; i < a.length -1; i++) {
            for(int j=0; j<a.length - i -1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
