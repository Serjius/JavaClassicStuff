package com.company;

import java.util.Arrays;

/**
 * an implementation of Binary Heap on Array
 * need to try rewrite with generics
 * <p>
 * Created by pss on 13.06.17.
 */
public class BinaryHeap {
    final static int DEFAULT_CAPACITY = 16;
    Node[] anArray;
    int anArraySize;

    private class Node {
        String nodeData;
        int nodeID;
        private String data;

        Node(String nodeData, int nodeID) {
            this.nodeData = nodeData;
            this.nodeID = nodeID;
        }

        @Override
        public String toString() {
            return "{" + "'" + nodeData + '\'' + ',' + nodeID + '}';
        }

        public int getNodeID() {
            return nodeID;
        }

        public String getData() {
            return nodeData;
        }
    }

    public BinaryHeap(int arraySize) {
        anArray = new Node[arraySize];
        anArraySize = -1;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(anArray) + "}";
    }

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public void addNewNode(String nodeData, int nodeID) {
        anArraySize++;

        if (anArraySize >= anArray.length) {
            growAnArrayUp();
        }

        anArray[anArraySize] = new Node(nodeData, nodeID);

        goUp();


    }

    private void goUp() {

        int i = anArraySize;
        int parent = getParent(i);
        while (i >= 0 && anArray[i].getNodeID() > anArray[parent].getNodeID()) {
            swapNodes(i, parent);
            i = parent;
            parent = getParent(i);
        }

    }

    public String getTopNode() {
        if (anArraySize < 0) {
            throw new IllegalStateException("Heap is empty");
        }

        Node n = anArray[0];
        anArray[0] = anArray[anArraySize];
        anArray[anArraySize] = null;
        anArraySize--;

        goDown();
        return n.getData();


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
            if (rightChild <= anArraySize && anArray[rightChild].getNodeID() > anArray[leftChild].getNodeID()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            //If the largest in the top -> stop
            if (anArray[i].getNodeID() >= anArray[largerChild].getNodeID()) {
                break;
            }

            swapNodes(i, largerChild);

            //go to largest sub-tree
            i = largerChild;

        }
    }

    private void swapNodes(int i, int j) {
        Node t = anArray[i];
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
