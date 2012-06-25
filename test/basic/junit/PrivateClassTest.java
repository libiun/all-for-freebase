package basic.junit;

import java.lang.reflect.Method;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class PrivateClassTest {

    public PrivateClassTest() {
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

    /*
     * 使用反射机制测试私有方法
     */
    @Test
    public void testAdd() {
        try {
            PrivateClass pc = new PrivateClass();
            Class<PrivateClass> classType = PrivateClass.class;
            Method method = classType.getDeclaredMethod("add", new Class[]{int.class, int.class});
            method.setAccessible(true);
            Object result = method.invoke(pc, new Object[]{5, 4});
            assertEquals(9, result);
        } catch (Exception ex) {
            fail();
        }
    }


}
