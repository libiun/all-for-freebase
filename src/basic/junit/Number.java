package basic.junit;

public class Number {

    public int add(int a, int b) {
        try {
            Thread.sleep(300);
        } catch (Exception e) {
        }

        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int mulitpy(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws Exception {
        if (0 == b) {
            throw new MyException("除数不能为0！");
        }
        return a / b;
    }
}

class MyException extends Exception {

    private static final long serialVersionUID = 1L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}