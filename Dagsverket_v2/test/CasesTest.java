/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import backend.*;
import frontend.*;

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
public class CasesTest {
    
    public CasesTest() {
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
    public void testCreateCaseFail() {
        // Cases is tested
        Cases cases = new Cases();
        ArrayList<Integer> errors = cases.createCase(1, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null);
        int size = errors.size();
        int expected = 7;
        // check if we got 7 errors (7 specific fields need to be inserted)
        assertEquals("Skal være 7.", expected, size);
    }
    
    @Test
    public void testCreateCaseSucceed() {
        // Cases is tested
        Cases cases = new Cases();
        ArrayList<Integer> errors = cases.createCase(1, "10-04-2014", "Kjell", "Tuff", "Klokkarvegen 2", "7540", "Klæbu", "22334455","Maling UTE", "20-05-2014", "08:00", "Maling av hus, 4 vegger", 2, "1000", "10-05-2014", "20-05-2014", "Malingskoster. Maling har kunden", "Ingar 99933999", "Aktiv");
        
        int size = errors.size();
        int expected = 0;
        // check if we got 0 errors (everything is filled in correctly)
        assertEquals("Skal være 0.", expected, size);
    }
    
    @Test
    public void testCreateCaseError1() {
        // Cases is tested
        Cases cases = new Cases();
        // characters in the phonenumber
        ArrayList<Integer> errors = cases.createCase(1, "10-04-2014", "Kjell", "Tuff", "Klokkarvegen 2", "7540", "Klæbu", "22a","Maling UTE", "20-05-2014", "08:00", "Maling av hus, 4 vegger", 2, "1000", "10-05-2014", "20-05-2014", "Malingskoster. Maling har kunden", "Ingar 99933999", "Aktiv");
        
        int size = errors.size();
        int expected = 2;
        // check if we got 2 errors (phonenumber parse and check if more then 0(after parse))
        assertEquals("Skal være 2.", expected, size);
    }
    
    // registrer oppmøte - ny klasse
    
    // display case
    
    @Test
    public void testUpdateCaseList() {
        Cases cases = new Cases();
        cases.updateCaseList("Aktiv");
        
        Case testCase = cases.getCaseById(1);
        String fornavn = testCase.getEmployer().getFirstname();
        assertEquals("Skal bli Per", fornavn, "Per");
    }
    
    @Test
    public void testUpdateCaseListEtternavn() {
        Cases cases = new Cases();
        cases.updateCaseList("Aktiv");
        
        Case testCase = cases.getCaseById(1);
        String etternavn = testCase.getEmployer().getLastname();
        assertEquals("Skal bli Persen", etternavn, "Persen");
    }
}
