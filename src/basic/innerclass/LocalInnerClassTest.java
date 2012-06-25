package basic.innerclass;

//局部内部类，可以定义在方法里面
//不能被定义成public或static
//只能访问final local变量
class LocalInner {

    public void doSomething() {

        final int a=4;

        class Inner3 {
            //定义在方法里面的局部内部类

            public void test() {
                System.out.println("hello");
                System.out.println(a); //只能访问final的内部变量
            }
        }

        new Inner3().test();
    }
}

public class LocalInnerClassTest {

    public static void main(String[] args) {
        LocalInner var = new LocalInner();
        var.doSomething();

    }
}
