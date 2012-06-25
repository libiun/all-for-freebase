package basic.Thread;

//1
//notify wait of object
//notify 与 wait 一定成对出现
public class Sample {

    private int number;

    public synchronized void increase() {
        if (0 != number) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        number++;
        System.out.println(number);
        notify();
    }

    public synchronized void decrease() {
        if (0 == number) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        number--;
        System.out.println(number);
        notify();
    }
}

