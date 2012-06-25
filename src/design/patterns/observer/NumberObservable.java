package design.patterns.observer;
//四个角色：
//抽象观察者，抽象被观察者
//具体观察者，具体被观察者
import java.util.Observable;
import java.util.Observer;

class NumberObserver1 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者一：" + arg);
    }
}

class NumberObserver2 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (((Integer) arg).intValue() <= 5) {
            System.out.println("观察者二：" + arg);
        }
    }
}

public class NumberObservable extends Observable {

    public void counter(int number) {
        for (; number >= 0; number--) {
            this.setChanged();
            this.notifyObservers(number);
        }
    }

    public static void main(String[] args) {
        NumberObservable nb = new NumberObservable();
        nb.addObserver(new NumberObserver1());
        nb.addObserver(new NumberObserver2());
        nb.counter(10);
    }
}
