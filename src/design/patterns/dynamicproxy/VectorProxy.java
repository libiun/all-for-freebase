package design.patterns.dynamicproxy;
//2
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author libiun
 */
public class VectorProxy implements InvocationHandler {

    private Object proxyObj;

    public VectorProxy(Object obj) {
        this.proxyObj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling:" + method);
        if (null != args) {
            for (Object obj : args) {
                System.out.println(obj);
            }
        }

        Object object = method.invoke(proxyObj, args);
        System.out.println("after calling:" + method);
        return object;

    }

    public static Object factory(Object obj) {
        Class<?> classType = obj.getClass();
        return Proxy.newProxyInstance(classType.getClassLoader(), classType.getInterfaces(),
                new VectorProxy(obj));
    }

    public static void main(String[] args) {
        List v = (List) factory(new Vector());
        v.add("new");
        v.add("york");
        v.remove(0);
        System.out.println(v);
    }
}
