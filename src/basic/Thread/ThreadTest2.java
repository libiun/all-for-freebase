package basic.Thread;

public class ThreadTest2 {

    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println("hello:" + i);
//                }
//            }
//        });
//        thread.start();

        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread2());
        t1.start();
        t2.start();

    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hello:" + i);
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("welcome:" + i);
        }
    }
}
