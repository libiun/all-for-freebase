package basic.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//套件的一层层封装
@RunWith(Suite.class)
@Suite.SuiteClasses(TestAll.class)
public class TestAll2 {
}
