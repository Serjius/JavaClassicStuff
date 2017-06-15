package com.company;

import java.util.Arrays;

/**
 * an implementation of Binary Heap on Array with generics
 * <p>
 * Created by pss on 14.06.17.
 */
public class BinaryHeapGenerics<T extends Comparable<T>> {
    final static int DEFAULT_CAPACITY = 16;
    Object[] anArray;
    int anArraySize;

    public BinaryHeapGenerics(int arraySize) {
        anArray = new Object[arraySize];
        anArraySize = -1;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(anArray) + "}";
    }

    public BinaryHeapGenerics() {
        this(DEFAULT_CAPACITY);
    }

    public void addNewNode(T n) {
        anArraySize++;

        if (anArraySize >= anArray.length) {
            growAnArrayUp();
        }

        anArray[anArraySize] = n;

        goUp();


    }

    private void goUp() {

        int i = anArraySize;
        int parent = getParent(i);
        while (i >= 0 && ((T) anArray[i]).compareTo((T) anArray[parent]) > 0) {
            swapNodes(i, parent);
            i = parent;
            parent = getParent(i);
        }

    }

    public T getTopNode() {
        if (anArraySize < 0) {
            throw new IllegalStateException("Heap is empty");
        }

        T n = (T) anArray[0];
        anArray[0] = anArray[anArraySize];
        anArray[anArraySize] = null;
        anArraySize--;

        goDown();
        return n;


    }

    private void goDown() {
        int i = 0;
        int leftChild;
        int rightChild;
        int largerChild;

        while (i < (anArraySize + 1) / 2) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;

            //If Right child presents Left presents also
            if (rightChild <= anArraySize && ((T) anArray[rightChild]).compareTo((T) anArray[leftChild]) > 0) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            //If the largest in the top -> stop
            if ( ((T) anArray[i]).compareTo((T)anArray[largerChild])>0) {
                break;
            }

            swapNodes(i, largerChild);

            //go to largest sub-tree
            i = largerChild;

        }
    }

    private void swapNodes(int i, int j) {
        T t = (T)anArray[i];
        anArray[i] = anArray[j];
        anArray[j] = t;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private void growAnArrayUp() {
        anArray = Arrays.copyOf(anArray, anArray.length * 2);
    }

}
