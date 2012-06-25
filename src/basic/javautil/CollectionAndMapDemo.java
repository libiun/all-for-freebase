package basic.javautil;

import java.util.*;

public class CollectionAndMapDemo {

    public static Collection addElement(Collection c) {
        c.add("yellow");
        c.add("bule");
        c.add("black");
        return c;
    }

    public static Map addElement(Map m) {
        m.put(1, "yellow");
        m.put(2, "red");
        m.put(3, "black");
        return m;
    }

    public static void main(String[] args) {
        /*
         * 基于哈希表的 Map 接口的实现。此实现提供所有可选的映射操作，
         * 并允许使用 null 值和 null 键。（除了非同步和允许使用 null 之外，
         * HashMap 类与 Hashtable 大致相同。）此类不保证映射的顺序，
         * 特别是它不保证该顺序恒久不变。
         */
        Map m = new HashMap();  //向上转型，创建一个map对象
        m = CollectionAndMapDemo.addElement(new HashMap());
        m.put(4, "hello,bitch");

        Collection c = new Vector();
        c = CollectionAndMapDemo.addElement(new Vector());
        c.add(m); //c可以放置任何对象，可以把map也放进去。

        System.out.println(c);
        System.out.println(m);

    }
}
