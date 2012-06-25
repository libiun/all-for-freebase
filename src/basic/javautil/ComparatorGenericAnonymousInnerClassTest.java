package basic.javautil;
// 使用泛型使字符在treeset里倒序
//匿名内部类，泛型，比较器comparator
//策略模式：
//抽象策略角色：策略类，通常由一个接口或者抽象类实现(这个例子中的comparator接口)
//具体策略角色：包含了相关的算法和行为(匿名内部类，最下面实现的MyComparator类)
//环境角色：持有一个策略类的引用，最终给客户端调用。（treeset，持有策略类的引用）
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorGenericAnonymousInnerClassTest {

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {

            @Override
            public int compare(String str1, String str2) {
                return str2.compareTo(str1);
            }
        });
        set.add("c");
        set.add("a");
        set.add("b");
        set.add("d");
        set.add("e");

        //System.out.println(set);
        for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
            //treeset自然排序
        }

    }
}
//class MyComparator implements Comparator<String>{
//
//    @Override
//    public int compare(String str1, String str2) {
//        return str2.compareTo(str1);//s1 s2的倒序
//    }
//}