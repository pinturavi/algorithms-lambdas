package com.pintu;

import java.util.Arrays;

public class BubbleSortSample {
    private static void bubblesort(int[] arr){

        final var n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp  = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {

        int [] numbers = {4, 6, 2, 1, 0, 5};

        bubblesort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
}
