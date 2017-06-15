package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pss on 14.06.17.
 */
public class BinaryHeapGenericsTest {

    @Test
    public void testDefaultConstructorInteger() {
        BinaryHeapGenerics<Integer> bh = new BinaryHeapGenerics<>();

        assertEquals("{[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]}", bh.toString());
    }

    @Test
    public void testDefaultConstructorString() {
        BinaryHeapGenerics<String> bh = new BinaryHeapGenerics<>();

        assertEquals("{[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]}", bh.toString());
    }

    @Test
    public void testSizeConstructorInteger() {
        BinaryHeapGenerics<Integer> bh = new BinaryHeapGenerics<>(3);

        assertEquals("{[null, null, null]}", bh.toString());
    }

    @Test
    public void testSizeConstructorString() {
        BinaryHeapGenerics<String> bh = new BinaryHeapGenerics<>(3);

        assertEquals("{[null, null, null]}", bh.toString());
    }

    @Test
    public void testAddNewNodeInteger() {
        BinaryHeapGenerics<Integer> bh = new BinaryHeapGenerics<>(3);

        bh.addNewNode(2);
        bh.addNewNode(1);
        assertEquals("{[2, 1, null]}", bh.toString());
    }

    @Test
    public void testAddNewNodeString() {
        BinaryHeapGenerics<String> bh = new BinaryHeapGenerics<>(3);

        bh.addNewNode("B");
        bh.addNewNode("A");
        assertEquals("{[B, A, null]}", bh.toString());
    }

    @Test
    public void testGrowingInteger() {
        BinaryHeapGenerics<Integer> bh = new BinaryHeapGenerics<>(3);

        bh.addNewNode(4);
        bh.addNewNode(3);
        bh.addNewNode(2);
        bh.addNewNode(1);

        assertEquals("{[4, 3, 2, 1, null, null]}", bh.toString());
    }

    @Test
    public void testGrowingString() {
        BinaryHeapGenerics<String> bh = new BinaryHeapGenerics<>(3);

        bh.addNewNode("D");
        bh.addNewNode("C");
        bh.addNewNode("B");
        bh.addNewNode("A");

        assertEquals("{[D, C, B, A, null, null]}", bh.toString());
    }

    @Test
    public void testGoUpInteger() {
        BinaryHeapGenerics<Integer> bh = new BinaryHeapGenerics<>(3);

        bh.addNewNode(1);
        bh.addNewNode(2);
        bh.addNewNode(4);
        bh.addNewNode(3);

        assertEquals("{[4, 3, 2, 1, null, null]}", bh.toString());
    }

    @Test
    public void testGoUpString() {
        BinaryHeapGenerics<String> bh = new BinaryHeapGenerics<>(3);

        bh.addNewNode("A");
        bh.addNewNode("B");
        bh.addNewNode("C");
        bh.addNewNode("D");

        assertEquals("{[D, C, B, A, null, null]}", bh.toString());
    }


    @Test
    public void testGoDownInteger() {
        BinaryHeapGenerics<Integer> bh = new BinaryHeapGenerics<>(3);

        bh.addNewNode(17);
        bh.addNewNode(13);
        bh.addNewNode(2);
        bh.addNewNode(30);
        bh.addNewNode(1);
        bh.addNewNode(11);
        bh.addNewNode(8);

        assertEquals(Integer.valueOf(30), bh.getTopNode());
        assertEquals(Integer.valueOf(17), bh.getTopNode());
        assertEquals(Integer.valueOf(13), bh.getTopNode());
        assertEquals(Integer.valueOf(11), bh.getTopNode());
        assertEquals(Integer.valueOf(8), bh.getTopNode());
        assertEquals(Integer.valueOf(2), bh.getTopNode());
        assertEquals(Integer.valueOf(1), bh.getTopNode());
    }

    @Test
    public void testGoDownString() {
        BinaryHeapGenerics<String> bh = new BinaryHeapGenerics<>(3);

        bh.addNewNode("R");
        bh.addNewNode("G");
        bh.addNewNode("C");
        bh.addNewNode("Z");
        bh.addNewNode("A");
        bh.addNewNode("T");
        bh.addNewNode("W");

        assertEquals(String.valueOf('Z'), bh.getTopNode());
        assertEquals(String.valueOf('W'), bh.getTopNode());
        assertEquals(String.valueOf('T'), bh.getTopNode());
        assertEquals(String.valueOf('R'), bh.getTopNode());
        assertEquals(String.valueOf('G'), bh.getTopNode());
        assertEquals(String.valueOf('C'), bh.getTopNode());
        assertEquals(String.valueOf('A'), bh.getTopNode());
    }


}
