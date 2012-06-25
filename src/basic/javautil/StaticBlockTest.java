package basic.javautil;

//输出的是什么？静态代码块的执行顺序
/*
 * parent static block
 * child static block
 * parent constructor content
 * child constructor content
 */
//静态的先执行
public class StaticBlockTest {

    public static void main(String[] args) {

        new Child();//输出的是什么？

    }
}

class Parent {

    private static String name;

    static {
        System.out.println("parent static block");
    }

    public Parent() {
        System.out.println("parent constructor content");
    }
}

class Child extends Parent {

    static {
        System.out.println("child static block");
    }

    public Child() {
        System.out.println("child constructor content");
    }
}