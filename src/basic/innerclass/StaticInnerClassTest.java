package basic.innerclass;
//静态内部类
class StaticInner {

    private static int a = 4;

    public static void testStaticMethod() {
        System.out.println("hello you");
    }

    //静态的只能访问外部类的静态成员
    public static class Inner {

        public void test() {
            System.out.println(a);
            testStaticMethod();
        }
    }
}

public class StaticInnerClassTest {

    public static void main(String[] args) {
        StaticInner.Inner inner = new StaticInner.Inner();
        inner.test();
    }
}
