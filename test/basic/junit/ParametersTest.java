package basic.junit;

//参数化测试
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParametersTest {

    private int excepted;
    private int input1;
    private int input2;
    private Number number;

    //下面两个方法是不同的地方。是规定的写法。
    @Parameters
    public static Collection prepareData() {
        Object[][] object = {{3, 1, 2}, {-4,-1,-3}, {5, 2, 3},{-4,4,-8}};
        return Arrays.asList(object);
    }

    public ParametersTest(int expected, int input1, int input2) {
        this.excepted = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Before
    public void setUp() {
        number = new Number();
    }

    @Test
    public void testAdd() {
        assertEquals(this.excepted, number.add(this.input1,this.input2));
    }
}
