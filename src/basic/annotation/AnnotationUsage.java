package basic.annotation;

@AnnotationTest(value2=EnumTest.Welcome)
public class AnnotationUsage {

    @AnnotationTest(value2=EnumTest.Welcome)
    public void method() {
        System.out.println("usage of annotation");
    }

    public static void main(String[] args) {
        AnnotationUsage usage = new AnnotationUsage();
        usage.method();
    }
}
