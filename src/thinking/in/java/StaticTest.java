package thinking.in.java;
//静态代码块和构造方法的执行时机
public class StaticTest {

    public static void main(String[] args) {
//        P p = new P();
//        P p2 = new P();
        new S(); //父类的静态代码块，父类的构造方法的顺序
        new S();
    }
}
// p q s
class P {

    static {
        //静态代码块先于构造方法执行
        System.out.println("p static block");
    }

    public P() {
        System.out.println("p constructor");
    }
}

class Q extends P {

    static {
        System.out.println("q static block");
    }

    public Q() {
        System.out.println("q constructor ");
    }
}

class S extends Q{
    static {
        System.out.println("s static block");
    }

    public S(){
        System.out.println("s constructor");
    }
}