package basic.enums;
//what ever
public enum Coin {
    //定义枚举类型时本质上就是定义一个类别，只不过编译器帮完成了底部细节
    //所以某些程度上，enum类似于class,interface
    //我们定义的类型继承与java.lang.Enum类
    //每个枚举成员是枚举类型的一个实例instance,设为fianl static成员，最重要的是他们是public
    penny("hello"), nickel("world"), dime("welcome"), quarter("hello world");
    private String value;

    public String getValue() {
        return value;
    }

    private Coin(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Coin coin = Coin.quarter;
        System.out.println(coin.getValue());
        System.out.println(coin.getDeclaringClass());
        System.out.println(coin.getClass());
    }
}
