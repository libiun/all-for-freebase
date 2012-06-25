package basic.reflect;

//这个例子举例了对方法的调用invoke函数
import java.lang.reflect.Method;

class SomeClass {

    public String concatString(String str1, String str2) {
        return str1 + str2;
    }
}

public class InvokeTestAgain {

    public static void main(String[] args) throws Exception {
        Class<?> classType = SomeClass.class;
        Object object = classType.newInstance();
        Method method = classType.getDeclaredMethod("concatString", new Class[]{String.class, String.class});
        String result = (String) method.invoke(object, new Object[]{"lijun love ", "liyuan"});
        System.out.println(result);

    }
}
