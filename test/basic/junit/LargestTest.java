package basic.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LargestTest {

    public LargestTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLargest() {
        assertEquals(9, Largest.largest(new int[]{7, 8, 9}));
        assertEquals(9, Largest.largest(new int[]{9, 8, 7}));
        assertEquals(9, Largest.largest(new int[]{8, 9, 7}));
        assertEquals(9, Largest.largest(new int[]{9, 8, 7}));
        assertEquals(9, Largest.largest(new int[]{7, 9, 7}));
        assertEquals(9, Largest.largest(new int[]{7, 9, 7, 9}));
        assertEquals(9, Largest.largest(new int[]{7, 9, -7, -9}));
        assertEquals(9, Largest.largest(new int[]{9, -9, -7, -9}));
        assertEquals(-7, Largest.largest(new int[]{-9, -7, -8}));
    }

    @Test
    public void testEmpty() {
        try {
            Largest.largest(new int[]{});
            fail("should have thrown an exception");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
