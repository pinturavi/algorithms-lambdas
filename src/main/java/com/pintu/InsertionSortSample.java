package com.pintu;

import java.util.Arrays;

public class InsertionSortSample {
    public static void main(String[] args) {
        int [] numbers = {2, 4, 0, 1, 3, 6 , 5};
        insertionsort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void insertionsort(int[] numbers) {

        int n = numbers.length;
        int key;
        int j;
        for (int i = 1; i < n; i++) {
            key = numbers[i];
            j = i - 1;
            while (j >=0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                --j;
            }

            numbers[j + 1] = key;
        }
    }
}
