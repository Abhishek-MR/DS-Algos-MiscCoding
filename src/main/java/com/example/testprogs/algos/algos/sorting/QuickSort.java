package com.example.testprogs.algos.algos.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter n");
        int n = s.nextInt();
        System.out.println("Enter "+n+" elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=s.nextInt();
        }
        QuickSort mergeSort = new QuickSort();
        mergeSort.sort(a);
        System.out.println("Sorted");
        for (int i: a) {
            System.out.print(i+"\t");
        }
    }

    public void sort(int[] a) {
        quicksort(a, 0 , a.length-1);
    }

    private void quicksort(int[] a, int l, int r) {

        if (l < r) {
            System.out.println("quicksort");
            System.out.println(Arrays.toString(a));
            int p = partition(a,l,r);
            quicksort(a,l,p-1);
            quicksort(a,p+1,r);
        }

    }

    private int partition(int[] a, int start, int end) {

        int pindex = start;
        System.out.println("pindex : "+pindex);

        int pivot = a[end];
        System.out.println("pivot : "+pivot);

        for (int i = start; i < end ; i++) {
            if(a[i] < pivot) {
                int temp = a[pindex];
                a[pindex] = a[i];
                a[i] = temp;
                pindex++;
            }
        }
        int temp = a[pindex];
        a[pindex] = pivot;
        a[end] = temp;

        System.out.println("partition");
        System.out.println(Arrays.toString(Arrays.copyOfRange(a,start,end+1)));
        return pindex;

    }

}
