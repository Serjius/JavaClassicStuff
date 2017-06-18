package com.company;

import java.util.Arrays;

/**
 * Created by pss on 15.06.17.
 * <p>
 * try to remember QS
 */
public class QuickSort {

    public static void sortAsc(int[] array) {
        quickSort(array, 0, array.length - 1, true);
    }

    public static void sortDesc(int[] array) {
        quickSort(array, 0, array.length - 1, false);
    }

    private static void quickSort(int[] array, int s, int f, boolean isAsc) {
        int l = s;
        int r = f;
        int p = array[(l + r) / 2];
        while (l < r) {
            if (isAsc) {
                while (array[l] < p) l++;
            } else {
                while (array[l] > p) l++;
            }
            if (isAsc) {
                while (array[r] > p) r--;
            } else {
                while (array[r] < p) r--;
            }

            if (l <= r) {
                swap(array, l, r);
                l++;
                r--;
            }
        }
        if (s < r) quickSort(array, s, r, isAsc);
        if (l < f) quickSort(array, l, f, isAsc);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
