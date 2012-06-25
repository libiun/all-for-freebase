package basic.javautil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class IteratorTest {

    public static void main(String[] args) {
        HashSet<Integer> integerSet = new LinkedHashSet<Integer>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);
        integerSet.add(5);
        //set.add(5); //有5，这个不会添加。因为set无序不重复

        for (Iterator<Integer> iter = integerSet.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }
}
