package basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestPrivate {

    public static void main(String[] args) throws Exception {
        //对private.java private方法的访问
        Private p = new Private();
        Class<?> classType = p.getClass();
        Method method = classType.getDeclaredMethod("sayHello", new Class[]{String.class});
        method.setAccessible(true); //压制java语言的访问控制检查
        String str = (String) method.invoke(p, new Object[]{"zhangsan"});
        System.out.println(str);

        //对private2 private 属性的修改
        Private2 p2 = new Private2();
        Class<?> classType2 = p2.getClass();
        Field field = classType2.getDeclaredField("name");
        //方法和变量的getDeclare和getField的差别在于前者返回公有和私有，后者自返回公有
        field.setAccessible(true);
        field.set(p2, "liyuan");
        Object str1=(String)field.get(p2);
        System.out.println(str1);
        //System.out.println(p2.getName());


        /**
         * 反射流程：
         * 1.生成class的对象
         * 2.可以用constructor构造类的对象，如果要用无参数的构造方法可以直接调用class对象的newInstance方法
         * 3.可以获取方法或属性getDeclaredMethod,Field
         * 4.method的invoke调用方法，访问属性用get,set方法
         * 5.返回结果就是一般方法的结果
         * 6.操控结果
         */


    }
}

class Private2 {

    private String name = "lijun";

    public String getName() {
        return name;
    }
}

class Private {

    private String sayHello(String name) {
        return "hello" + name;
    }
}