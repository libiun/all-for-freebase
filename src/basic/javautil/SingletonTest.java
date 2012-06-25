package basic.javautil;
//单例模式,只有一个实例
public class SingletonTest {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        //对于Object对象来说,equals与==是相同的。
        System.out.println(singleton.equals(singleton2));
    }
}

class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
