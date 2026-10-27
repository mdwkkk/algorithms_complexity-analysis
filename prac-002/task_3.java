
package org.example;

import java.util.Arrays;

public class task_3 {
    public static void main(String[] args) {
        int[] arr = {10000, 0, 25, 25};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr.length == 0) return;
        int min = arr[0];
        int max = arr[0];
        for (int val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        int range = max - min + 1;
        int[] count = new int[range];

        for (int val : arr) {
            int offset = val - min;
            count[offset]++;
        }

        int index = 0;
        for (int offset = 0; offset < count.length; offset++){
            for (int repeat = 0; repeat < count[offset]; repeat++){
                arr[index++] = offset + min;
            }
        }

    }
}
