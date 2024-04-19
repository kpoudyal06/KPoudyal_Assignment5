package com.example.morsecode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MorseCodeTreeTest_STUDENT {

    MorseCodeTree testTree;
    ArrayList<String> testArr;

    @Before
    public void setUp() throws Exception {
        testTree = new MorseCodeTree();
    }

    @After
    public void tearDown() throws Exception {
        testTree = null;
        testArr = null;
    }

    @Test
    public void testGetRoot() {
        testTree.setRoot(new TreeNode<> ("kyle"));
        assertEquals(testTree.getRoot().getData(), "kyle");
    }

    @Test
    public void testSetRoot() {
        try {
            testTree.setRoot(new TreeNode<> ("kyle"));
        }
        catch (Exception e) {
            fail("This should not have caused an exception");
        }
    }

    @Test
    public void testInsert() {
        try {
            testTree.insert(".", "e");
        }
        catch (Exception e) {
            fail("This should not have caused an exception");
        }
    }

    @Test
    public void testAddNode() {
        try {
            testTree.addNode(testTree.getRoot(), ".", "e");
        }
        catch (Exception e) {
            fail("This should not have caused an exception");
        }
    }

    @Test
    public void testFetch() {
        assertEquals(testTree.fetch("."), "e");
        assertEquals(testTree.fetch("..."), "s");
    }

    @Test
    public void testFetchNode() {
        assertEquals(testTree.fetchNode(testTree.getRoot(), "-..."), "b");
        assertEquals(testTree.fetchNode(testTree.getRoot(), "..-"), "u");
    }

    @Test
    public void testBuildTree() {
        try {
            testTree.buildTree();
        }
        catch (Exception e) {
            fail("This should not have caused an exception");
        }
    }

    @Test
    public void testToArrayList() {
        testArr = testTree.toArrayList();
        assertEquals("h", testArr.get(0));
        assertEquals("s", testArr.get(1));
    }

    @Test
    public void testLNRoutputTraversal() {
        testArr = testTree.toArrayList();
        try {
            testTree.LNRoutputTraversal(testTree.getRoot(), testArr);
        }
        catch (Exception e) {
            fail("This should not have caused an exception");
        }
    }


}
