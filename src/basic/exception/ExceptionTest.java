package basic.exception;

public class ExceptionTest {

    public static void main(String[] args) {
        try {
            SomeClass obj = new SomeClass();
            obj.doOne();
            obj.doTwo();
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
            System.out.println("4");
        } catch (MyException ex) {
            ex.printStackTrace();
        } catch (MyException2 ex) {
            ex.printStackTrace();
        }catch(Exception e){
           //要注意异常捕获的顺序
        }
    }
}

class SomeClass {

    public void doOne() throws MyException {
        System.out.println("自定义类继承异常类，并抛出异常");
        throw new MyException("messge:doOne throw a exception.");
    }

    public void doTwo() throws MyException2 {
        System.out.println("自定义异常类");
        throw new MyException2("message:doTwo throw a exception.");
    }
}

class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }

    public MyException() {
        super();
    }
}

class MyException2 extends IllegalAccessError {

    public MyException2(String s) {
        super(s);
    }

    public MyException2() {
    }
}