package basic.reflect;

import java.lang.reflect.Array;

public class ArrayTester2 {

    public static void main(String[] args) {
        int[] dims = new int[]{5, 56, 63};
        Object array = Array.newInstance(Integer.TYPE, dims);//创建长宽高为5，56，63的三维数组
        System.out.println(array instanceof int[][][]);
        Object arrayObj = Array.get(array, 3);
        //下面两行可省略
        Class<?> classType = arrayObj.getClass().getComponentType();
        System.out.println(classType);
        arrayObj = Array.get(arrayObj, 5); //返回一位数组
        Array.setInt(arrayObj, 10, 37);
        int[][][] arrayCast = (int[][][]) array;
        System.out.println(arrayCast[3][5][10]);
        //System.out.println(Integer.TYPE);  //return:int
        //System.out.println(Integer.class); //return:class java.lang.Integer
    }
}
