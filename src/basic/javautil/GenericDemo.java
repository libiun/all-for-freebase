package basic.javautil;

/**
 *
 * @param <T>
 * @author libiun
 */
public class GenericDemo<T> {

    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }


    public static void main(String[] args) {
        GenericDemo<Boolean> bool=new GenericDemo<Boolean>();
        GenericDemo<Integer> integer=new GenericDemo<Integer>();

        bool.setFoo(Boolean.TRUE);
        bool.getFoo();
        integer.setFoo(Integer.SIZE);
        integer.getFoo();
    }
}
