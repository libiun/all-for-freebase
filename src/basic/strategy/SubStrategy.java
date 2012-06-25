package basic.strategy;

public class SubStrategy implements Strategy{

    @Override
    public int calculate(int a, int b) {
        return a-b;
    }

}
