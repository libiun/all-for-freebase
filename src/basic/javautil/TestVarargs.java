package basic.javautil;
//可变参数用3个点,代表数组
public class TestVarargs {

    private int a = 4;

    private static int sum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //return sum+a;
        return sum;
    }

    public static void main(String[] args) {
        //静态方法只能访问静态方法，通过不构建对象
        int result = sum(new int[]{3, 4});
        System.out.println(result);

        int s = sum(2, 3, 4, 5, 6, 4);
        System.out.println(s);
    }
}
