package thinking.in.java;

import java.util.Properties;

public class Property {

    private int i;

    public Property(int x) {
        this.i = x;
    }

    public Property(int x, int y) {
        this(x);//用this关键字帮助在一个构造函数内调用另一个构造函数
        System.out.println(this.i + y);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public static void testProperties() {
        Properties p = System.getProperties();
        //properties是一个hashtable，不推荐使用put,putAll方法
        //使用getProperty方法查询所需字符
        String s = p.getProperty("hello");

        if (s == null) {
            System.out.println("no hello key");
        } else {
            System.out.println("error");
        }

        p.setProperty("lijun", "loveliyuan");
        p.list(System.out);
        System.out.println("memery usage:------");
        Runtime runTime = Runtime.getRuntime();
        System.out.println("total memory:" + runTime.totalMemory() + ";free memory:" + runTime.freeMemory());
    }

    public static void objectEquivalence() {
        Integer i1 = new Integer(3);
        Integer i2 = new Integer(3);
        System.out.println(i1 == i2); //false,不是原生类型，是对象，这是比较句柄，两者当然不同
        System.out.println(i1 != i2); //true
        System.out.println(i1.equals(i2)); //对象的比较用equals方法，true
        i1 = i2;  //i2的句柄消失
        System.out.println(i1 == i2); //true
        System.out.println(i1.equals(i2));//true
        int i3 = 5;
        int i4 = 5;
        System.out.println(i3 == i4); //这是原生类型的比较，相等，true
        //equals方法比较对象的内容而不是其句柄，所以string都应该用这个做比较
    }

    public static void main(String[] args) {
        //将3付给x，调用第一个构造函数将x赋予i
        //new Property(3,4); 
    }
}
