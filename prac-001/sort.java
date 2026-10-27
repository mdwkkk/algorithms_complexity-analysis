package org.example;

import java.util.Arrays;

public class sort {
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) min = j;
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};

        System.out.println("До сортировки: " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("После сортировки: " + Arrays.toString(arr));
    }
}
