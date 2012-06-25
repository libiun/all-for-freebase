package basic.generic;
//with parents 实现泛型集成

public class Childs<T1, T2, T3> extends Parents<T1, T2> {

    private T3 foo3;

    public T3 getFoo3() {
        return foo3;
    }

    public void setFoo3(T3 foo3) {
        this.foo3 = foo3;
    }
}
