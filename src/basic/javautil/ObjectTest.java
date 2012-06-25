package basic.javautil;

public class ObjectTest {
    public static void main(String[] args) {
        Object obj=new Object();
        System.out.println(obj);
        System.out.println(obj.toString());
        System.out.println(obj.getClass());

        //public String toString() {
	//    return this;
        //} 字符串类的重写toString方法
        String str="-----------";
        System.out.println(str.toString()); //有无toString一样

        Student student=new Student();
        System.out.println(student);
        System.out.println(student.toString());

    }
}

class Student extends Object{

    @Override
    public String toString() {
        return "hello";
    }

}
