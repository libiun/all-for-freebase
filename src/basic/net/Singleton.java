package basic.net;
//会产生多线程问题
public class Singleton {

    //private static Singleton singleton = new Singleton();
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == singleton) {
            try {
                Thread.sleep((long) (Math.random() * 4000));
                singleton = new Singleton();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        //两个对象不想等，违背singleton模式
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Singleton.getInstance());
    }
}
