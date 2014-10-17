/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal;

import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author mormon
 */
public class journalIdeaNGTest {
    
    public journalIdeaNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getDate method, of class journalIdea.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        journalIdea instance = new journalIdea();
        String expResult = "";
        String result = instance.getDate();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class journalIdea.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        journalIdea instance = new journalIdea();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class journalIdea.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        journalIdea instance = new journalIdea();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class journalIdea.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        journalIdea instance = new journalIdea();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTopics method, of class journalIdea.
     */
    @Test
    public void testGetTopics() {
        System.out.println("getTopics");
        journalIdea instance = new journalIdea();
        List expResult = null;
        List result = instance.getTopics();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScriptures method, of class journalIdea.
     */
    @Test
    public void testGetScriptures() {
        System.out.println("getScriptures");
        journalIdea instance = new journalIdea();
        ArrayList expResult = null;
        ArrayList result = instance.getScriptures();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class journalIdea.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        journalIdea instance = new journalIdea();
        String expResult = "";
        String result = instance.getContent();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
