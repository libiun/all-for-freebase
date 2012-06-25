package basic.enums;
//enum也是类，只不过定义实例时把实例放在内部，使用构造方法来定义
import java.lang.reflect.Method;

public enum ClassMates {

    Lijun(29, "信息系统研究与开发"),
    Liyuan(30, "信息法"),
    Xuzhengzheng(25, "信息安全"),
    Jingyoushun(34, "i don't know");
    private int age;
    private String major;

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    private ClassMates(int age, String major) {
        this.age = age;
        this.major = major;
    }

    public static void main(String[] args) throws Exception{
        ClassMates mate = ClassMates.Lijun;
        System.out.println(ClassMates.Jingyoushun.getAge());
        System.out.println(mate.name() + ":" + mate.getAge() + ":" + mate.getMajor());
        System.out.println("--------2");

        //Class<?> classType=ClassMates.class;
        //Class<?> classType=ClassMates.Jingyoushun.getClass();
        Class<?> classType=Class.forName("basic.enums.ClassMates");
        Method[] methods=classType.getDeclaredMethods();
        for(Method m:methods){
            System.out.println(m);
        }

        System.out.println("-----------3");
        System.out.println(mate.getDeclaringClass()); //等同于直接使用getClass()
        System.out.println(ClassMates.valueOf("Lijun"));
        for(ClassMates c:ClassMates.values()){
            System.out.println(c+":"+c.getMajor());
        }
    }
}
