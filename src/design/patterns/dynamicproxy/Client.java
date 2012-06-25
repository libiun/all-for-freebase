package design.patterns.dynamicproxy;
//1
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * @author libiun
 * 动态代理步骤：
 * 1.创建一个实现接口invocationhandler的类，实现invoke方法
 * 2.创建被代理的类以及接口
 * 3.通过proxy的静态方法newProxyInstance创建一个代理
 * 4.通过代理调用方法
 *
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject=new RealSubject();

        InvocationHandler handler=new DynamicSubject(realSubject);
        Class<?> classType=handler.getClass();
        //下面的代码一次性生成代理
        Subject subject=(Subject)Proxy.newProxyInstance(classType.getClassLoader(),
                realSubject.getClass().getInterfaces(),handler);

        subject.request();

        System.out.println(subject.getClass());

    }
}
