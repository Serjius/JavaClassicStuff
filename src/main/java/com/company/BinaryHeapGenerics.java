package com.company;

import java.util.Arrays;

/**
 * an implementation of Binary Heap on Array with generics
 * <p>
 * Created by pss on 14.06.17.
 */
public class BinaryHeapGenerics<T extends Comparable<T>> {
    final static int DEFAULT_CAPACITY = 16;
    Object[] array;
    int size;

    public BinaryHeapGenerics(int arraySize) {
        array = new Object[arraySize];
        size = 0;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(array) + "}";
    }

    public BinaryHeapGenerics() {
        this(DEFAULT_CAPACITY);
    }

    public void addNewNode(T n) {

        if (size >= array.length) {
            growAnArrayUp();
        }

        array[size] = n;
        size++;

        goUp();


    }

    private void goUp() {

        int i = size-1;
        int parent = getParent(i);
        while (i > 0 && ((T) array[i]).compareTo((T) array[parent]) > 0) {
            swapNodes(i, parent);
            i = parent;
            parent = getParent(i);
        }

    }

    public T getTopNode() {
        if (array[0] == null) {
            throw new IllegalStateException("Heap is empty");
        }

        size--;
        T n = (T) array[0];
        array[0] = array[size];
        array[size] = null;

        goDown();
        return n;


    }

    private void goDown() {
        int i = 0;
        int leftChild;
        int rightChild;
        int largerChild;

        while (i < (size) / 2) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;

            //If Right child presents Left presents also
            if (rightChild <= size-1 && ((T) array[rightChild]).compareTo((T) array[leftChild]) > 0) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            //If the largest in the top -> stop
            if ( ((T) array[i]).compareTo((T) array[largerChild])>0) {
                break;
            }

            swapNodes(i, largerChild);

            //go to largest sub-tree
            i = largerChild;

        }
    }

    private void swapNodes(int i, int j) {
        T t = (T) array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private void growAnArrayUp() {
        array = Arrays.copyOf(array, array.length * 2);
    }

}
