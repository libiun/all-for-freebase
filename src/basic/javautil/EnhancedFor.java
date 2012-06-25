package basic.javautil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EnhancedFor {

    public static void main(String[] args) {
        //一维数组
        /*
        int[] arr = {1, 2, 3, 65};
        for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
        }

        for (int a : arr) {
        System.out.println(a);
        }
         */
        System.out.println("--------");

        int[][] arr2 = {{2, 4, 5}, {324, 545, 645, 0, 0}, {234, 3, 432, 4}};
        for (int[] row : arr2) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println("--------");

        Collection<String> col = new ArrayList<String>();
        col.add("one");
        col.add("two");
        col.add("three");
        col.add("four");
        for (String str : col) {
            System.out.println(str);
        }

        System.out.println("--------");

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        //method1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //method2
        for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
        //method3,丢掉了索引的信息，如果需要针对位置元素做操作，使用第一种
        for (String str : list) {
            System.out.println(str);
        }

    }
}
