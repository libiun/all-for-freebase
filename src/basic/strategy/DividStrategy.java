package basic.strategy;

public class DividStrategy implements Strategy {

    @Override
    public int calculate(int a, int b) {
        if (b == 0) {
            return 0;
        } else {
            return a / b;
        }
    }
}
