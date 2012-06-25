package basic.annotation;

public class OverrideTest {

    @Override
    public String toString() {
        return "this is overridetest";

    }

    public static void main(String[] args) {
        OverrideTest test = new OverrideTest();
        System.out.println(test);
    }
}
