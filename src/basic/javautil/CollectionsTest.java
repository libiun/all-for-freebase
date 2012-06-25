package basic.javautil;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

//Collections定义了对集合的常用操作
//相对与Arrays对数组定义了常用操作

@SuppressWarnings("unchecked")
public class CollectionsTest {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(-10);
        list.add(1210);
        list.add(52);

        //原本按照从小到大的自然顺序排序的，用比较器强制逆转
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(list, comparator);

        for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
            System.out.print(String.valueOf(iter.next()) + " ");
        }

        System.out.println("-------------");
        //乱序方法
        Collections.shuffle(list);
        for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
            System.out.print(String.valueOf(iter.next()) + " ");
        }

        System.out.println("-------------");
        System.out.println("min value:"+Collections.min(list));
        System.out.println("max value:"+Collections.max(list));
    }
}
