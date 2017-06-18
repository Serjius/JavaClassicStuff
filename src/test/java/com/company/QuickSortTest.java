package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by pss on 15.06.17.
 */
public class QuickSortTest {

    @Test
    public void testSortAsc1() {
        int[] a = {1, 2, 19, 23, 12, 11, 33, 5, 4, 5, 5, 5, 5, 5};
        QuickSort.sortAsc(a);

        assertEquals("[1, 2, 4, 5, 5, 5, 5, 5, 5, 11, 12, 19, 23, 33]", Arrays.toString(a));


    }

    @Test
    public void testSortDesc1() {
        int[] a = {1, 2, 19, 23, 12, 11, 33, 5, 4, 5, 5, 5, 5, 5};
        QuickSort.sortDesc(a);

        assertEquals("[33, 23, 19, 12, 11, 5, 5, 5, 5, 5, 5, 4, 2, 1]", Arrays.toString(a));


    }

    @Test
    public void testSortAsc2() {
        int[] a = {1, 17, 2};
        QuickSort.sortAsc(a);

        assertEquals("[1, 2, 17]", Arrays.toString(a));


    }

    @Test
    public void testSortDesc2() {
        int[] a = {1, 17, 2};
        QuickSort.sortDesc(a);

        assertEquals("[17, 2, 1]", Arrays.toString(a));


    }
}
