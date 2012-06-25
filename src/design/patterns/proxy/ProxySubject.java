package design.patterns.proxy;

public class ProxySubject extends Subject {

    private RealSubject realSubject; //代理角色内部引用了真实角色

    @Override
    public void request() {
        this.preRequest(); //在真实角色操作之前附加的操作
        if (null == realSubject) {
            realSubject = new RealSubject();
        }

        realSubject.request();//真实角色完成的事情
        this.postRequest();//在真实角色操作之后附加的操作
    }

    //代理角色自生的事情
    private void preRequest(){
        System.out.println("pre request");
    }

    private void postRequest(){
        System.out.println("post request");
    }
}
