package com.example.testprogs.algos.algos.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter n");
        int n = s.nextInt();
        System.out.println("Enter "+n+" elements");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=s.nextInt();
        }
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);
        System.out.println("Sorted");
        for (int i: a) {
            System.out.print(i+"\t");
        }
    }

    public void sort(int[] a) {
        mergesort(a,0,a.length-1);
    }

    private void mergesort(int[] a, int l , int r) {

        System.out.println("divide");
        System.out.println(Arrays.toString(Arrays.copyOfRange(a,l,r+1)));
        if (l<r) {
            int m = (l + r) / 2;
            mergesort(a,l,m);
            mergesort(a,m+1,r);
            merge(a,l,m,r);
        }
    }

    private void merge(int[] a, int start, int mid, int end) {
        int tot = end-start+1;
        int[] res = new int[tot];
        int c = 0;
        int i=start,j=mid+1;
        while(i<=mid && j<=end) {
            if(a[i] < a[j]) {
                res[c++] = a[i++];
            }else {
                res[c++] = a[j++];
            }
        }

        while (i<=mid) {
            res[c++] = a[i++];
        }

        while (j<=end) {
            res[c++] = a[j++];
        }

        for(i = start; i <= end; ++i) {
            a[i] = res[i - start];
        }

        System.out.println("merge");
        System.out.println(Arrays.toString(a));

    }
}
