package basic.Polymorphism;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecursionTest {

    public RecursionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of comupte method, of class Recursion.
     */
    @Test
    public void testComupte() {
        System.out.println("comupte");
        int i = 5;
        Recursion instance = new Recursion();
        int expResult = 120;
        int result = instance.comupte(i);
        assertEquals(expResult, result);
     }

    /**
     * Test of computeFab method, of class Recursion.
     */
    @Test
    public void testComputeFab() {
        System.out.println("computeFab");
        int i = 7;
        Recursion instance = new Recursion();
        int expResult = 13;
        int result = instance.computeFab(i);
        assertEquals(expResult, result);

    }
}
