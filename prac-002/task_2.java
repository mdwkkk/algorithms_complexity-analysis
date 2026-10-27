package org.example;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class task_2 {
    public static void main (String[] args) {
        double[] arr = {0.25, 0.10, 0.80, 0.45};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(double[] arr) {
        if (arr.length == 0) return;
        int s = arr.length;
        List<List<Double>> buckets = new ArrayList<>(s);

        for (int i = 0; i < s; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double val : arr) {
            if (!(val >= 0 && val <1.0)) {
                return;
            }
            int index = Math.min(s - 1, (int) (val * s));
            buckets.get(index).add(val);
        }

        System.out.println(buckets);
        int index = 0;
        for (List<Double> bucket : buckets) {
            System.out.println("До сортировки: " + bucket.toString());
            insertionSort(bucket);
            System.out.println("После сортировка: " + bucket.toString());
            for (double val: bucket) {
                arr[index++] = val;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void insertionSort(List<Double> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            double key = bucket.get(i);
            int j = i - 1;

            while (j >= 0 && bucket.get(i) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }
}

