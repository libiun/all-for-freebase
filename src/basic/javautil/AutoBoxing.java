package basic.javautil;

import java.util.ArrayList;
import java.util.Collection;

public class AutoBoxing {

    public static void main(String[] args) {
        int a = 3;
        Collection<Integer> c = new ArrayList<Integer>();
        //8个原生类型的包厢和拆箱autoboxing,autounboxing
        c.add(3);//自动将int类型的3转换成Integer放进去
        c.add(a + 3);
        for (Integer i : c) {
            System.out.println(i);
        }
    }
}
