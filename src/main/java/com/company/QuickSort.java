package com.company;

/**
 * Created by pss on 15.06.17.
 * <p>
 * try to remember QS
 */
public class QuickSort {

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int finish) {
        if (start < finish) {
            int pivot = array[(start + finish) / 2];
            int left = start;
            int right = finish;
            while (left <= right) {
                while (array[left] < pivot) {
                    left++;
                }
                while (array[right] > pivot) {
                    right--;
                }

                if (left <= right) {
                    swap(array, left, right);
                    left++;
                    right++;
                }

            }
            quickSort(array, start, right);
            quickSort(array, left, finish);

        }

    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    ;


}
