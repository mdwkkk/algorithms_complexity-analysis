
package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

class SortTest {

    @ParameterizedTest
    @MethodSource("testSelectionSort")
    void testSelectionSortWorst(int N) {
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = N - i;
        }

        long start = System.nanoTime();
        sort.selectionSort(arr);
        long time = System.nanoTime() - start;

        System.out.println("Worst case, N = " + N + ", time = " + time + " ns");

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @ParameterizedTest
    @MethodSource("testSelectionSort")
    void testSelectionSortBest(int N) {
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        long start = System.nanoTime();
        sort.selectionSort(arr);
        long time = System.nanoTime() - start;

        System.out.println("Best case, N = " + N + ", time = " + time + " ns");

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @ParameterizedTest
    @MethodSource("testSelectionSort")
    void testSelectionSortAverage(int N) {
        Random random = new Random(7777);
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(100);
        }

        long start = System.nanoTime();
        sort.selectionSort(arr);
        long time = System.nanoTime() - start;

        System.out.println("Average case, N = " + N + ", time = " + time + " ns");

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    static Stream<Arguments> testSelectionSort() {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(10),
                Arguments.of(100),
                Arguments.of(1000),
                Arguments.of(2000),
                Arguments.of(4000),
                Arguments.of(8000),
                Arguments.of(16000),
                Arguments.of(32000),
                Arguments.of(64000),
                Arguments.of(128000)
        );
    }
}

