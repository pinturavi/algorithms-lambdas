package com.pintu;

import java.util.Arrays;

public class MergeSortSample {

    static void mergesort(int[] a, int p, int r) {
        if (p < r) {
            int q =  p + (r - p) /2;
            mergesort(a, p, q);
            mergesort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    private static void merge(int[] a, int p, int q, int r) {
        final int n1 = q - p + 1;
        final int n2 = r - q;

        final int[] leftArr = new int[n1 + 1];
        final int[] rightArr = new int[n2 + 1];

        int x = p;
        for (int i = 0; i < n1; i++) {
            leftArr[i] = a[x];
            ++x;
        }

        x = q + 1;
        for (int i = 0; i <n2; i++) {
            rightArr[i] = a[x];
            ++x;
        }

        leftArr[n1]= Integer.MAX_VALUE;
        rightArr[n2]= Integer.MAX_VALUE;

        int i =0,  j=0;

        for (int k = p; k <= r; k++) {
            if (leftArr[i] < rightArr[j]) {
                a[k] = leftArr[i];
                i++;
            } else{
                a[k] = rightArr[j];;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {4, 6, 2, 1, 0, 5};
        mergesort(numbers, 0, numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }
}
