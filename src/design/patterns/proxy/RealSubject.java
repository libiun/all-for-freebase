package design.patterns.proxy;
//真实角色
public class RealSubject extends Subject {

    @Override
    public void request() {
        System.out.println("from real subject.");
    }

}
