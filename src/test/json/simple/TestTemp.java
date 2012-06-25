package test.json.simple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestTemp {

    /**
     * 打印List类型参数的每个元素
     * @param list 
     */
    public static void printItemList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6);
        for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }

        List<String> list2 = Arrays.asList("a,", "b", "c");
        for (Iterator<String> iter2 = list2.iterator(); iter2.hasNext();) {
            System.out.println(iter2.next());
        }
    }
}
