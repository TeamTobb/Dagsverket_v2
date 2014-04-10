/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import backend.*;
import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author borgarlie
 */
public class EmployeesTest {
    
    public EmployeesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testCreateEmployee() {
        Employees test = new Employees();
        ArrayList<Integer> errors = test.createEmployee("", "");
        int expected = 2;
        int errorSize = errors.size();
        // empty string should not be possible, should be 2 errors.
        assertEquals("Errors should be 0. ", expected, errorSize);
    }
    
    @Test
    public void testCreateEmployeeSucceed() {
        Employees test = new Employees();
        ArrayList<Integer> errors = test.createEmployee("Test", "Testesen");
        int expected = 0;
        int errorSize = errors.size();
        // everything is inserted correctly, should be 0 errors.
        assertEquals("Errors should be 0. ", errorSize, expected);
    }
}
