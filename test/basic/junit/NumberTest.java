package basic.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumberTest {

    private Number number;

    public NumberTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("invoked before class");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("invoked after class");
    }

    @Before
    public void setUp() {
        System.out.println("invoked before method");
        number = new Number();
    }

    @After
    public void tearDown() {
        System.out.println("invoked after method");
    }

    @Test(timeout = 600)
    public void testAdd() {
        assertEquals(4, number.add(1, 3));
    }

    @Test
    public void testSubstract() {
        assertEquals(4, number.substract(989, 985));
    }

    @Test
    public void testMulitpy() {
        assertEquals(9, number.mulitpy(3, 3));
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(4, number.divide(12, 3));
    }

    @Test(expected = MyException.class)
    public void testDivideByZero() throws Exception {
        //使用注解Test的参数能很方便的处理异常情况
        number.divide(3, 0);
    }

    @Test
    @Ignore("the reason ignore this test")
    public void ingoreTest() {
        fail("this test will be ignored, so all this tests wil be ok.");
    }
}
