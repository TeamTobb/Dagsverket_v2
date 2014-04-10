/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import backend.*;
import java.util.*;

public class SalesTest {
    
    public SalesTest() {
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
    /*
          Check if it is possible to insert empty strings. Should return 10 errors.
    */
    public void testCreateSale1(){
        Sales testSales = new Sales();
        
        int expected = 10;
        
        ArrayList<Integer> errors = testSales.createSale("", "", "", "", "", "", "", "", "");
        
        assertEquals("testing: skal bli 0.", expected, errors.size());
    }
    
   @Test
   /*
        Check if it catches 3 errors where int fields cant be lower or equals to zero
   */
   public void testCreateSale2(){
       Sales testSales = new Sales();
       
       int expected = 3;
       
       ArrayList<Integer> errors = testSales.createSale("0","0","0","0","0","0","0","0","0");
       
       assertEquals("testing: skal bli 3.", expected, errors.size());
   }
   
   @Test
   /*
        Check if it catches 6 errors when entering strings into number fields
   */
   public void testCreateSale3(){
       Sales testSales = new Sales();
       
       int expected = 6;
       
       ArrayList<Integer> errors = testSales.createSale("na","na","na","na","na","na","na","na","na");
       
       assertEquals("testing: skal bli 6.", expected, errors.size());
   }
   
    @Test
   /*
        Check if the method works as intended with intended input
    */
   public void testCreateSale4(){
       Sales testSales = new Sales();
       
       int expected = 0;
       
       ArrayList<Integer> errors = testSales.createSale("Thomas","Haugrud","47903837","Eik","2320","Stensbakkvegen 23","4","FURNES","aktiv");
       
       assertEquals("testing: skal bli 0.", expected, errors.size());
   }
}
