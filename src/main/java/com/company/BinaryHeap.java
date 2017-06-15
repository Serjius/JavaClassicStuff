package com.company;

import java.util.Arrays;

/**
 * an implementation of Binary Heap on Array
 * need to try rewrite with generics
 * <p>
 * Created by pss on 13.06.17.
 */
public class BinaryHeap {
    private final static int DEFAULT_CAPACITY = 16;
    private Node[] nodes;
    private int size;

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
        nodes = new Node[arraySize];
        this.size = 0;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(nodes) + "}";
    }

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public void addNewNode(String nodeData, int nodeID) {

        if (size >= nodes.length) {
            growAnArrayUp();
        }

        nodes[size] = new Node(nodeData, nodeID);
        size++;

        goUp();


    }

    private void goUp() {

        int i = size - 1;
        int parent = getParent(i);
        while (i > 0 && nodes[i].getNodeID() > nodes[parent].getNodeID()) {
            swapNodes(i, parent);
            i = parent;
            parent = getParent(i);
        }

    }

    public String popTopNode() {
        if (nodes[0] == null) {
            throw new IllegalStateException("Heap is empty");
        }

        size--;
        Node n = nodes[0];
        nodes[0] = nodes[size];
        nodes[size] = null;

        goDown();
        return n.getData();


    }

    private void goDown() {
        int i = 0;
        int leftChild;
        int rightChild;
        int largerChild;

        while (i < size / 2) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;

            //If Right child presents Left presents also
            if (rightChild <= size - 1 && nodes[rightChild].getNodeID() > nodes[leftChild].getNodeID()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            //If the largest in the top -> stop
            if (nodes[i].getNodeID() >= nodes[largerChild].getNodeID()) {
                break;
            }

            swapNodes(i, largerChild);

            //go to largest sub-tree
            i = largerChild;

        }
    }

    private void swapNodes(int i, int j) {
        Node t = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = t;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private void growAnArrayUp() {
        nodes = Arrays.copyOf(nodes, nodes.length * 2);
    }

}
