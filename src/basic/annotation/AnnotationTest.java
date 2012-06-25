package basic.annotation;

public @interface AnnotationTest {
    //定义一个注解
    String value1() default "hello";
    EnumTest value2();
    //value是默认的，在使用时可以不写value="..."
}

enum EnumTest{
    Hello,World,Welcome;
}