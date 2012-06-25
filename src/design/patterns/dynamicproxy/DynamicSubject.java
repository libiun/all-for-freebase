package design.patterns.dynamicproxy;
//1
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author libiun
 * 该代理类的内部属性是Object类型，实际使用的时候通过该类的构造方法传递进来一个对象
 * 此外，该类还实现了invoke方法，该方法中的method.invoke其实就是调用被代理的对象
 * 将要执行的方法，方法参数是sub，表示方法从属与sub，通过动态代理类，我们可以
 * 在执行真实对象的方法前后加入自己的一些额外方法。
 *
 * spring框架就是使用动态代理实现机制
 */
public class DynamicSubject implements InvocationHandler {

    private Object sub;

    public DynamicSubject(Object obj) {
        this.sub = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling:" + method);

        method.invoke(sub, args);

        System.out.println("after calling:" + method);

        return null;
    }
}
