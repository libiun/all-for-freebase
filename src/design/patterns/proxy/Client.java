package design.patterns.proxy;

public class Client {
//租房者,struct2就是代理模式
    public static void main(String[] args) {
        Subject subject=new ProxySubject();
        //System.out.println(subject);
        subject.request();
    }
}
