package basic.Thread;

public class ThreadTest {

    public static void main(String[] args) {
        Thread1 t1 = new Thread1("first thread 0");
        Thread2 t2 = new Thread2();

        System.out.println(t1.getName());
        System.out.println(t2.getClass());
        t1.start();
        t2.start();
        //结果每次都不会一样。但如果通过run方法就不会以线程的方式运行，只会作为普通类方法运行
    }
}

class Thread1 extends Thread {

    public Thread1(String name){
    super(name);
}

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hello world: " + i);
        }
    }
}

class Thread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("welcome: " + i);
        }
    }
}