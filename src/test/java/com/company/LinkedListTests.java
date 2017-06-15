package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by ows on 12.06.17.
 */
public class LinkedListTests {

    @Test
    public void testAddNodeToTheHead() {
        LinkedList ll = new LinkedList();
        ll.addNodeToTheHead("First", 1);
        ll.addNodeToTheHead("Second", 2);
        ll.addNodeToTheHead("Threed", 3);
        ll.addNodeToTheHead("Forth", 4);

        assertEquals("{'Forth',4}{'Threed',3}{'Second',2}{'First',1}", ll.printAllNodesInOneSting());

    }

    @Test
    public void testAddNodeAfterOldOne() {
        LinkedList ll = new LinkedList();
        ll.addNodeToTheHead("First", 1);
        ll.addNodeToTheHead("Second", 2);
        ll.addNodeToTheHead("Threed", 3);
        ll.addNodeToTheHead("Forth", 4);

        ll.addNodeAfterNode("Second.1", 100, 3);

        assertEquals("{'Forth',4}{'Threed',3}{'Second.1',100}{'Second',2}{'First',1}", ll.printAllNodesInOneSting());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNodeAfterOldOnePhantomNode() {
        LinkedList ll = new LinkedList();
        ll.addNodeToTheHead("First", 1);
        ll.addNodeToTheHead("Second", 2);
        ll.addNodeToTheHead("Threed", 3);
        ll.addNodeToTheHead("Forth", 4);

        ll.addNodeAfterNode("Second.1", 100, -3);
    }


    @Test
    public void testAddNodeToTheEnd() {
        LinkedList ll = new LinkedList();
        ll.addNodeToTheEnd("First", 1);
        ll.addNodeToTheEnd("Second", 2);
        ll.addNodeToTheEnd("Threed", 3);
        ll.addNodeToTheEnd("Forth", 4);

        assertEquals("{'First',1}{'Second',2}{'Threed',3}{'Forth',4}", ll.printAllNodesInOneSting());

    }

    @Test
    public void testDeleteNodeFromTheEnd() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);
        normalList.addNodeToTheEnd("Threed", 3);
        normalList.addNodeToTheEnd("Forth", 4);

        normalList.deleteNodeFromTheEnd();

        assertEquals("Regular list", "{'First',1}{'Second',2}{'Threed',3}", normalList.printAllNodesInOneSting());

        LinkedList emptyList = new LinkedList();
        emptyList.deleteNodeFromTheEnd();

        assertEquals("Empty List", "", emptyList.printAllNodesInOneSting());

        LinkedList oneNodeList = new LinkedList();
        oneNodeList.addNodeToTheEnd("First", 1);
        oneNodeList.deleteNodeFromTheEnd();

        assertEquals("One Node List", "", oneNodeList.printAllNodesInOneSting());

        LinkedList twoNodesList = new LinkedList();
        twoNodesList.addNodeToTheEnd("First", 1);
        twoNodesList.addNodeToTheEnd("Second", 2);
        twoNodesList.deleteNodeFromTheEnd();

        assertEquals("Two Nodes List", "{'First',1}", twoNodesList.printAllNodesInOneSting());


    }

    @Test
    public void testDeleteNodeFromTheHeadRegularList() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);
        normalList.addNodeToTheEnd("Threed", 3);
        normalList.addNodeToTheEnd("Forth", 4);

        normalList.deleteNodeFromTheHead();
        assertEquals("Regular list", "{'Second',2}{'Threed',3}{'Forth',4}", normalList.printAllNodesInOneSting());
    }

    @Test
    public void testDeleteNodeFromTheHeadEmptyList() {
        LinkedList emptyList = new LinkedList();

        emptyList.deleteNodeFromTheHead();
        assertEquals("Empty List", "", emptyList.printAllNodesInOneSting());
    }

    @Test
    public void testDeleteNodeFromTheHeadOneNodeList() {
        LinkedList oneNodeList = new LinkedList();
        oneNodeList.addNodeToTheEnd("First", 1);

        oneNodeList.deleteNodeFromTheHead();
        assertEquals("One Node List", "", oneNodeList.printAllNodesInOneSting());
    }

    @Test
    public void testDeleteNodeFromTheHeadTwoNodesList() {
        LinkedList twoNodesList = new LinkedList();
        twoNodesList.addNodeToTheEnd("First", 1);
        twoNodesList.addNodeToTheEnd("Second", 2);

        twoNodesList.deleteNodeFromTheHead();
        assertEquals("Two Nodes List", "{'Second',2}", twoNodesList.printAllNodesInOneSting());
    }

    @Test
    public void testDeleteNodeAfterOldOneRegularList() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);
        normalList.addNodeToTheEnd("Threed", 3);
        normalList.addNodeToTheEnd("Forth", 4);

        normalList.deleteNodeAfterNode(2);
        assertEquals("Regular list", "{'First',1}{'Second',2}{'Forth',4}", normalList.printAllNodesInOneSting());

        normalList.deleteNodeAfterNode(2);
        assertEquals("Regular list", "{'First',1}{'Second',2}", normalList.printAllNodesInOneSting());


        normalList.deleteNodeAfterNode(1);
        assertEquals("Regular list", "{'First',1}", normalList.printAllNodesInOneSting());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNodeAfterOldOneEmptyList() {
        LinkedList emptyList = new LinkedList();

        emptyList.deleteNodeAfterNode(1);
    }

    @Test
    public void testDeleteNodeAfterOldOneOneNodeList() {
        LinkedList oneNodeList = new LinkedList();
        oneNodeList.addNodeToTheEnd("First", 1);

        oneNodeList.deleteNodeAfterNode(1);
        assertEquals("One Node List", "{'First',1}", oneNodeList.printAllNodesInOneSting());
    }

    @Test
    public void testDeleteNodeAfterOldOneTwoNodesList() {
        LinkedList twoNodesList = new LinkedList();
        twoNodesList.addNodeToTheEnd("First", 1);
        twoNodesList.addNodeToTheEnd("Second", 2);

        twoNodesList.deleteNodeAfterNode(1);
        assertEquals("Two Nodes List", "{'First',1}", twoNodesList.printAllNodesInOneSting());
    }

    @Test
    public void testAddNodeBeforeOldOneRegularList() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);
        normalList.addNodeToTheEnd("Threed", 3);
        normalList.addNodeToTheEnd("Forth", 4);

        normalList.addNodeBeforeNode("NewNode", 100, 2);
        assertEquals("Regular list", "{'First',1}{'NewNode',100}{'Second',2}{'Threed',3}{'Forth',4}", normalList.printAllNodesInOneSting());

    }

    @Test
    public void testAddNodeBeforeOldOneBeforeHead() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);

        normalList.addNodeBeforeNode("NewNode", 100, 1);
        assertEquals("Regular list", "{'NewNode',100}{'First',1}{'Second',2}", normalList.printAllNodesInOneSting());
    }

    @Test
    public void testAddNodeBeforeOldOneBeforeEnd() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);

        normalList.addNodeBeforeNode("NewNode", 100, 2);
        assertEquals("Regular list", "{'First',1}{'NewNode',100}{'Second',2}", normalList.printAllNodesInOneSting());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNodeBeforeOldOneEmptyList() {
        LinkedList emptyList = new LinkedList();

        emptyList.addNodeBeforeNode("A", 2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNodeBeforeOldOnePhantomList() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);
        normalList.addNodeToTheEnd("Threed", 3);
        normalList.addNodeToTheEnd("Forth", 4);

        normalList.addNodeBeforeNode("NewNode", 100, -1);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNodeBeforeOldOneEmptyList() {
        LinkedList emptyList = new LinkedList();
        emptyList.deleteNodeBeforeNode(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNodeBeforeOldOnePhantomList() {
        LinkedList emptyList = new LinkedList();
        emptyList.addNodeToTheEnd("First", 1);
        emptyList.deleteNodeBeforeNode(-1);
    }
    @Test
    public void testDeleteNodeBeforeOldOneOneNodeList() {
        LinkedList oneNodeList = new LinkedList();
        oneNodeList.addNodeToTheEnd("First", 1);

        oneNodeList.deleteNodeBeforeNode(1);
        assertEquals("One Node List", "{'First',1}", oneNodeList.printAllNodesInOneSting());
    }

    @Test
    public void testDeleteNodeBeforeOldOneTwoNodesList() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);

        normalList.deleteNodeBeforeNode(2);
        assertEquals("Two Nodes list", "{'Second',2}", normalList.printAllNodesInOneSting());
    }

    @Test
    public void testDeleteNodeBeforeOldOneRegularList() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);
        normalList.addNodeToTheEnd("Threed", 3);
        normalList.addNodeToTheEnd("Forth", 4);

        normalList.deleteNodeBeforeNode(3);
        assertEquals("Regular list", "{'First',1}{'Threed',3}{'Forth',4}", normalList.printAllNodesInOneSting());

        normalList.deleteNodeBeforeNode(4);
        assertEquals("Regular list", "{'First',1}{'Forth',4}", normalList.printAllNodesInOneSting());
    }

    @Test
    public void testCountEmptyList() {
        LinkedList emptyList = new LinkedList();
        assertEquals("Empty list", 0, emptyList.count());
    }

    @Test
    public void testCountRegularList() {
        LinkedList normalList = new LinkedList();
        normalList.addNodeToTheEnd("First", 1);
        normalList.addNodeToTheEnd("Second", 2);
        normalList.addNodeToTheEnd("Threed", 3);
        assertEquals("Regular list", 3, normalList.count());
    }
}
