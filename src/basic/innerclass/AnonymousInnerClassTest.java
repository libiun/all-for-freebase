package basic.innerclass;

//匿名内部类
import java.util.Date;

//local inner classes without class names
//no key word class
//no key word extends and implements
//no constructors
//隐式继承父类或实现一个接口
public class AnonymousInnerClassTest {

    @SuppressWarnings("deprecation")
    public String get(Date date) {
        return date.toLocaleString();
    }

    public static void main(String[] args) {
        AnonymousInnerClassTest test = new AnonymousInnerClassTest();

        //定义了匿名内部类，继承了Date类，没有重写Date的任意方法
        //传递给get的是这个子类
        String str = test.get(new Date() {
            //继承了date类，重写方法
            @Override
            @SuppressWarnings("deprecation")
            public String toLocaleString() {
                return "hello world";
            }
        });
        System.out.println(str);
    }
}
