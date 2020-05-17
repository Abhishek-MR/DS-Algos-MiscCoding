package com.example.testprogs.algos.sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter n");
        int n = s.nextInt();
        System.out.println("Enter "+n+" elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=s.nextInt();
        }
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(a);
        System.out.println("Sorted");
        for (int i: a) {
            System.out.print(i+"\t");
        }
    }

    public void sort(int[] a) {
        for (int i = 1; i <a.length ; i++) {
            int curr = a[i];
            int j=i-1;
            while (j>=0 && a[j]>curr) {
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1] = curr;
        }
    }
}
