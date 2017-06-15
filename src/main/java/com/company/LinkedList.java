package com.company;

/**
 * Let remember Linked List
 * <p>
 * Created by pss on 12.06.17.
 */
public class LinkedList {

    private Node headNode;

    private class Node {
        String nodeData;
        int nodeID;

        Node nextNode;

        Node(String nodeData, int nodeID) {
            this.nodeData = nodeData;
            this.nodeID = nodeID;
            this.nextNode = null;
        }

        public String toMinimalString() {
            return "{" + "'" + nodeData + '\'' + ',' + nodeID + '}';
        }
    }

    //Add a new Node to the Head
    public void addNodeToTheHead(String nodeData, int nodeID) {
        Node node = new Node(nodeData, nodeID);
        node.nextNode = headNode;
        headNode = node;
    }

    //Add a new node after old one by ID
    public void addNodeAfterNode(String nodeData, int nodeID, int oldNodeD) {
        Node oldNode = headNode;
        while (oldNode != null) {
            if (oldNode.nodeID == oldNodeD) {
                break;
            } else {
                oldNode = oldNode.nextNode;
            }
        }
        if (oldNode == null) {
            throw new IllegalArgumentException("Node with ID:" + oldNodeD + " doesn't found in the list");
        }

        Node newNode = new Node(nodeData, nodeID);
        newNode.nextNode = oldNode.nextNode;
        oldNode.nextNode = newNode;
    }

    //Add a new node to the end
    public void addNodeToTheEnd(String nodeData, int nodeID) {
        Node newNode = new Node(nodeData, nodeID);

        if (headNode == null) {
            headNode = newNode;
        } else {

            Node lastNode = headNode;
            while (lastNode.nextNode != null) {
                lastNode = lastNode.nextNode;
            }
            lastNode.nextNode = newNode;
        }
    }

    public void deleteNodeFromTheEnd() {
        //If the list is empty do nothing
        if (headNode != null) {
            // if the list has more than one node -> find the last and delete it
            if (headNode.nextNode != null) {
                Node lastNode = headNode;
                while (lastNode.nextNode.nextNode != null) {
                    lastNode = lastNode.nextNode;
                }
                lastNode.nextNode = null;
            } else {
                //else delete singular
                headNode = null;
            }
        }
    }

    public void deleteNodeFromTheHead() {
        //If the list is empty do nothing
        if (headNode != null) {
            // if the list has more than one node -> delete first node
            if (headNode.nextNode != null) {
                headNode = headNode.nextNode;
            } else {
                //else delete singular
                headNode = null;
            }
        }
    }

    //Return a string for all nodes just for test
    public String printAllNodesInOneSting() {
        StringBuilder allNodesString = new StringBuilder();
        Node n = headNode;
        while (n != null) {
            allNodesString.append(n.toMinimalString());
            n = n.nextNode;
        }
        return allNodesString.toString();
    }

    //Delete a node after old one by ID
    public void deleteNodeAfterNode(int oldNodeD) {
        Node oldNode = headNode;
        while (oldNode != null) {
            if (oldNode.nodeID == oldNodeD) {
                break;
            } else {
                oldNode = oldNode.nextNode;
            }
        }
        if (oldNode == null) {
            throw new IllegalArgumentException("Node with ID:" + oldNodeD + " doesn't found in the list");
        }

        //If it isn't the last node
        if (oldNode.nextNode != null) {
            oldNode.nextNode = oldNode.nextNode.nextNode;
        }
    }

    //Add a new node before old one by ID
    public void addNodeBeforeNode(String nodeData, int nodeID, int oldNodeD) {
        if (headNode == null) {
            throw new IllegalArgumentException("List is Empty. Node with ID:" + oldNodeD + " doesn't found in the list");
        }
        Node oldNode = headNode;
        Node newNode = new Node(nodeData, nodeID);

        //If isn't the first node
        if (oldNode.nodeID != oldNodeD) {
            while (oldNode.nextNode != null) {
                if (oldNode.nextNode.nodeID == oldNodeD) {
                    break;
                } else {
                    oldNode = oldNode.nextNode;
                }
            }
            if (oldNode.nextNode == null) {
                throw new IllegalArgumentException("Node with ID:" + oldNodeD + " doesn't found in the list");
            }
            newNode.nextNode = oldNode.nextNode;
            oldNode.nextNode = newNode;
        } else {
            newNode.nextNode = oldNode;
            headNode = newNode;
        }
    }


    //Delete a node before old one by ID
    public void deleteNodeBeforeNode(int oldNodeD) {
        if (headNode == null) {
            throw new IllegalArgumentException("List is Empty. Node with ID:" + oldNodeD + " doesn't found in the list");
        }
        Node oldNode = headNode;
        //If isn't the first node otherwise do nothing
        if (oldNode.nodeID != oldNodeD) {
            //We need to remember previous node
            Node prevNode = null;
            while (oldNode.nextNode != null) {
                if (oldNode.nextNode.nodeID == oldNodeD) {
                    break;
                } else {
                    prevNode = oldNode;
                    oldNode = oldNode.nextNode;
                }
            }
            if (oldNode.nextNode == null) {
                throw new IllegalArgumentException("Node with ID:" + oldNodeD + " doesn't found in the list");
            }
            if (prevNode == null) {
                headNode = oldNode.nextNode;
            } else {
                prevNode.nextNode = oldNode.nextNode;
            }
        }
    }

    //Count
    public int count() {
        Node node = headNode;
        int size = 0;
        while (node != null) {
            size++;
            node = node.nextNode;
        }
        return size;
    }

}
