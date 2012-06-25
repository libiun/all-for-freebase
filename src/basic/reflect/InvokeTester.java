package basic.reflect;

import java.lang.reflect.Method;

public class InvokeTester {

    public int add(int param1, int param2) {
        return param1 + param2;
    }

    public String echo(String message) {
        return "hell0 " + message;
    }

    public static void main(String[] args) throws Exception {

        //Class<?> classType=Class.forName("basic.reflect.InvokeTester");
        Class<?> classType = InvokeTester.class;
        Object invokeTester = classType.newInstance();
        //System.out.println(invokeTester instanceof InvokeTester);
        //后面跟一个int.class用来指定方法的参数，因为java允许方法多态，参数类型的指定就必须的

        Method addMethod = classType.getMethod("add", new Class[]{int.class, int.class});
        Object result = addMethod.invoke(invokeTester, new Object[]{4, 5});
        System.out.println(result);

        System.out.println("-----------");

        Method echoMethod = classType.getMethod("echo", new Class[]{String.class});
        Object result2 = echoMethod.invoke(invokeTester, new Object[]{"liyuan"});
        System.out.println(result2);
        System.out.println(InvokeTester.class+" ");

    }
}