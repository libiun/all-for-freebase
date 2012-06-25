package basic.strategy;

public class Client {

    public static void main(String[] args) {
        AddStrategy addStrategy = new AddStrategy();
        Environment environment = new Environment(addStrategy);
        System.out.println(environment.calculate(4, 5));

        SubStrategy subStrategy = new SubStrategy();
        environment.setStrategy(subStrategy);
        System.out.println(environment.calculate(4, 5));

        MultiplyStrategy multiplyStrategy = new MultiplyStrategy();
        environment.setStrategy(multiplyStrategy);
        System.out.println(environment.calculate(4, 56565));

        DividStrategy dividStrategy = new DividStrategy();
        environment.setStrategy(dividStrategy);
        System.out.println(environment.calculate(0, 0));
    }
}
