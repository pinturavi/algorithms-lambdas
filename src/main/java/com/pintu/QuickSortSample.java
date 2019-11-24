package com.pintu;

import java.util.Arrays;

public class QuickSortSample {
    public static void main(String[] args) {
        int [] numbers = {2, 6, 8, 1, 3, 5, 4};
        quicksort(numbers, 0, numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }

    private static void quicksort(int[] arr, int p, int r) {

        if (p < r) {
            int q = partition(arr, p, r);
            quicksort(arr, p, q - 1);
            quicksort(arr, q + 1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {

        int i = p -1,tmp;
        for (int j = p; j < r; j++) {
            if (arr[j] < arr[r]) {
                i += 1;
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        tmp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = tmp;
        return i+1;
    }
}
