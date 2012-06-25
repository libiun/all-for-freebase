package basic.generic;
//与child类共同实现泛型类的继承
public class Parents<T1, T2> {

    private T1 foo1;
    private T2 foo2;

    public T1 getFoo1() {
        return foo1;
    }

    public void setFoo1(T1 foo1) {
        this.foo1 = foo1;
    }

    public T2 getFoo2() {
        return foo2;
    }

    public void setFoo2(T2 foo2) {
        this.foo2 = foo2;
    }
}
