package design.patterns.proxy;

public class About {
    //代理模式涉及到的角色有：
    //抽象角色：声明真实对象和代理对象的共同接口
    //代理角色：（中介）代理对象角色内部 含有对真实对象的引用，从而可以操作真实对象
    //同时代理对象提供与真实对象相同的接口以便在任何时刻都能代替真实对象。
    //同时，代理对象可以在执行真实对象操作时，附加其他的操作，相当于对真实对象的封装
    //真实对象：代理角色所代表的真实对象，是我们最终要引用的对象（房主）
}