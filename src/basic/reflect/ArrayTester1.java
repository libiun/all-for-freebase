package basic.reflect;

import java.lang.reflect.Array;
import java.util.HashMap;

@SuppressWarnings("unchecked")
public class ArrayTester1 {

    public static void main(String[] args) throws Exception {
        Class<?> classType = Class.forName("java.lang.String");
        //生成长度为10的字符串数组
        //static Object = newInstance(Class<?> componentType, int length)
        //创建一个具有指定的组件类型和长度的新数组,componentType指定数组元素类型
        Object array = Array.newInstance(classType, 10);

        Array.set(array, 5, "hello");
        String str = (String) Array.get(array, 5);
        System.out.println(str);

        System.out.println("-------------------");

        //用反射机制操作hashmap
        Class<?> hashmapType = HashMap.class;
        HashMap<String, String> obj = (HashMap<String, String>) hashmapType.newInstance();
        obj.put("a", "a-value");
        obj.put("b", "b-value");
        System.out.println(obj);
    }
}
