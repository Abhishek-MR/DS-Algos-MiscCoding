package com.example.testprogs.algos.algos.sorting;

import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter n");
        int n = s.nextInt();
        System.out.println("Enter "+n+" elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=s.nextInt();
        }
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);
        System.out.println("Sorted");
        for (int i: a) {
            System.out.print(i+"\t");
        }
    }

    public void sort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;

            for (int j = i; j<a.length;j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}
