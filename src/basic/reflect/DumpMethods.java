package basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DumpMethods {

    public static void main(String[] args) throws Exception {
        //获取String类的所有方法和属性，包括publi,private
        Class<?> classType = Class.forName("java.lang.String");
        Method[] methodsAll = classType.getDeclaredMethods();

        Field[] fieldsAll = classType.getDeclaredFields();
        for (Method method : methodsAll) {
            System.out.println(method);
        }
        for (Field field : fieldsAll) {
            System.out.println(field);
        }
        System.out.println("------------");
        // 只获取pulic的
       Class<?> classType2 = Class.forName("java.lang.Exception");
       Method[] methodsPublic=classType2.getMethods();
       for(Method method2:methodsPublic){
           System.out.println(method2);
       }
    }
}
