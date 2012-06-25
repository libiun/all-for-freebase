package basic.Polymorphism;

public class PolyTest {

    public void run(Car car) {
        car.run();
    }

    public static void main(String[] args) {
        PolyTest p = new PolyTest();
        p.run(new Benz());
        p.run(new BMW());
        p.run(new QQ());

        //上面的例子显示多态性，
        //Java中的对象分为两种：一是原生数据类型，就是8个（byte,short,int,long,float,double,boolean,char）
        //第二种就是引用类型，reference type，如Car car，car就属于后者。
        //引用类型顾名思义就是指向了摸个具体对象，如new Benz();
        //父类的引用类型可以指向子类对象，可以调用父类本身有，子类继承或者重写的方法。
        //如果子类额外定义了方法，这个方法不是从父类继承的，则父类的引用类型（指向子类对象）不能直接调用子类的方法。如下例子：
        Car car = new Benz();
        car.run(); //没有问题
        //car.stop(); //错误，必须执行强制类型转换，即downcast，向下转型

        Motor motor = new BMW();  //父类引用指向子类对象
        BMW bmw = (BMW) motor;
        bmw.run();

        BMW bmw2 = new BMW();
        Motor motor1 = bmw2;  //这两句就是upcast，可以不强制
        Motor motor2 = (Motor) bmw2; //强制，但无意义
    }
}

interface Car {

    public void run();
}

class Motor {
}

class Benz implements Car {

    @Override
    public void run() {
        System.out.println("Benz is running!");
    }

    public void stop() {
        System.out.println("benz is stopping");
    }
}

class BMW extends Motor implements Car {   //必须类在前接口在后

    @Override
    public void run() {
        System.out.println("Bmw is running!");
    }
}

class QQ implements Car {

    @Override
    public void run() {
        System.out.println("QQ is running!");
    }
}