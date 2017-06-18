package com.company;

import java.util.Arrays;

/**
 * Created by pss on 15.06.17.
 * <p>
 * try to remember QS
 */
public class QuickSort {

    public static void sortAsc(int[] array) {
        quickSortAsc(array, 0, array.length - 1);
    }

    public static void sortDesc(int[] array) {
        quickSortDesc(array, 0, array.length - 1);
    }

    private static void quickSortDesc(int[] array, int s, int f) {
        int l = s;
        int r = f;
        int p = array[(l + r) / 2];
        while (l < r) {
            while (array[l] > p) {
                l++;
            }
            while (array[r] < p) {
                r--;
            }
            if (l <= r) {
                swap(array, l, r);
                l++;
                r--;
            }
        }
        if (s < r) {
            quickSortDesc(array, s, r);
        }
        if (l < f) {
            quickSortDesc(array, l, f);
        }
    }

    private static void quickSortAsc(int[] array, int start, int finish) {
        int l = start;
        int r = finish;
        int pivot = array[(start + finish) / 2];
        while (l < r) {
            while (array[l] < pivot) {
                l++;
            }
            while (array[r] > pivot) {
                r--;
            }
            if (l <= r) {
                swap(array, l, r);
                l++;
                r--;
            }
        }
        if (start < r) quickSortAsc(array, start, r);
        if (l < finish) quickSortAsc(array, l, finish);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
