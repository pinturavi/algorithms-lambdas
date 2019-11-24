package com.pintu;

import java.util.Arrays;

public class SelectionSortSample {

    private static void selectionsort(final int[] arr) {
        final var n = arr.length;
        int minIndex, tmp;
        int swaps=0;
        boolean isSwapped;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            isSwapped = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    isSwapped = true;

                }
                ++swaps;
            }
            if (!isSwapped) {
                System.out.println(swaps);
                return;
            }

            tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;

        }
        System.out.println(swaps);
    }
    public static void main(String[] args) {
        int[] numbers = {4, 6, 2, 1, 0, 5};
        //int[] numbers = {0, 1, 2, 4, 5, 6};
        selectionsort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
}
