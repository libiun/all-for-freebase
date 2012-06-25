package basic.javautil;

import java.util.Arrays;

/**
 * java.util.Arrays类的应用，用于数组的常用操作
 * 此类中所有的方法都是static
 * @author libiun
 */
public class ArraysDemo {

    public static void main(String[] args) {
        int[] a = new int[]{12, 2, 63, 4, 59};
        System.out.println("数组a的字符串形式：" + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("数组a排序后的字符串形式为：" + Arrays.toString(a));
        System.out.println("59在数组中的索引值为：" + Arrays.binarySearch(a, 59));
        //填充所有数组值为100
        Arrays.fill(a, 100);
        System.out.println("数组填充后的字符串形式为：" + Arrays.toString(a));
        //当a赋值给b后，a,b指向同一地址
        int[] b = a;
        System.out.println("数组a与b是否相等：" + Arrays.equals(a, b));
    }
}
