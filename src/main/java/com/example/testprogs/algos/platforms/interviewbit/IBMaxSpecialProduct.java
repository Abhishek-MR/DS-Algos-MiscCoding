package com.example.testprogs.algos.platforms.interviewbit;

public class IBMaxSpecialProduct {
    public int maxSpecialProduct(int[] A) {

        long maxspecialproduct = 0;

        for (int i=0; i<A.length;i++) {
            //li  A[j]>A[i] (i>j) maximum value of j
            long li = 0;
            //ri A[j]>A[i] (j>i) minimum value of j
            long ri = 0;
            for(int j=i-1; j>0;j--) {
                if(A[j] > A[i]) {
                    li = j;
                    break;
                }
            }
            for(int j=i+1; j<A.length;j++) {
                if(A[j] > A[i]) {
                    ri = j;
                    break;
                }
            }
            long pdct = li * ri;
            if(pdct > maxspecialproduct ) maxspecialproduct =pdct;
        }
        return (int)(maxspecialproduct%1000000007L);
    }

    public static void main(String[] args) {
        IBMaxSpecialProduct ibMaxSpecialProduct = new IBMaxSpecialProduct();
        int res =ibMaxSpecialProduct.maxSpecialProduct(new int[] { 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 });
        System.out.println(res);
    }
}
