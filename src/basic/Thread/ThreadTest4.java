package basic.Thread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadTest4 {

    public static void main(String[] args) {
        Example example = new Example();
        Thread t1 = new TheThread(example);
        Thread t2 = new TheThread(example);
        t1.start();
        t2.start();
    }
}

class Example {

    public synchronized void execute() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("example:" + i);
        }
    }
}

class TheThread extends Thread {

    private Example example;

    public TheThread(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        this.example.execute();
    }
}
