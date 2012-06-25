package design.patterns.dynamicproxy;
//1
/**
 *
 * @author libiun
 */
public class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("from real subject.");
    }

}
