package basic.exception;

/**
 *
 * @author libiun
 * java中异常分两大类
 * 1.checked exception:非runtime exception
 * 2.unchecked excepton:runtime exception
 *
 * 发生异常后面的代码不会再执行
 * RuntimeException类也是直接继承自exception类
 *
 */
public class About {

    public static void main(String[] args) {
        int c = 1;
        try {
            int a = 3;
            int b = 0;
            c = a / b; //这里会产生一个类,由catch接管
            System.out.println("hello");//异常后的代码不会执行
        } catch (Exception e) {
            e.printStackTrace(); //继承自throwable类，打印异常信息
        }finally{
            System.out.println("int finally");
        }
        //System.out.println("hello");
        System.out.println(c);
    }
}
