package basic.Polymorphism;
//递归函数首先考虑程序的出口
public class Recursion {

    public int comupte(int i) {
        //计算阶乘
        if (1 == i) {
            //出口
            return 1;
        } else {
            return i * comupte(i - 1);
        }
    }

    public int computeFab(int i) {
        if (1 == i || 2 == i) {
            return 1;
        } else {
            return computeFab(i - 1) + computeFab(i - 2);
        }
    }
}
