package basic.innerclass;

//成员内部类
class MemberInner {

    private int a = 4;

    public class InnerClass {

        private int a = 5;

        void doSomething() {
            System.out.println("hello.");
        }

        int getInnerA() {
            //返回内部类的成员变量
            return this.a;
        }

        int getOutterA(){
            //访问外部类的成员变量
            return MemberInner.this.a;
        }
    }
}

public class MemberInnerClassTest {

    public static void main(String[] args) {
        //内部类属于对象，每个对象多需要new来产生对象自生的内部类
        MemberInner.InnerClass inner = (new MemberInner()).new InnerClass();
        inner.doSomething();
        System.out.println(inner.getInnerA());
    }
}
