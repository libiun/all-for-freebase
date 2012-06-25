package basic.Thread;
//1
public class IncreaseThread extends Thread {

    private Sample sample;

    public IncreaseThread(Sample sample) {
        this.sample = sample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            sample.increase();
        }
    }
}
