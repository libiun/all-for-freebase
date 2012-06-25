package basic.enums;

import java.util.EnumSet;
import java.util.Iterator;

enum FontConstant {

    Plain, Bold, Italilc, Hello
}

public class EnumSetDemo {

    private FontConstant font;

    public static void showEnumSet(EnumSet<FontConstant> enumSet) {
        for (Iterator<FontConstant> iter = enumSet.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }

    public void test() {
        if (this.font == FontConstant.Bold) {
            System.out.println(true);
        }
    }

    public void setFont(FontConstant f) {
        this.font = f;
    }

    public static void main(String[] args) {
        //EnumSet em = EnumSet.allOf(FontConstant.class);//把所有FontConstant实例打印出来
        EnumSet<FontConstant> em = EnumSet.of(FontConstant.Bold);//构建由一个元素组成的EnumSet
        EnumSet<FontConstant> em1 = EnumSet.complementOf(em);//补足剩余元素形成一个enumset
        showEnumSet(em1);

        EnumSetDemo e = new EnumSetDemo();
        e.setFont(FontConstant.Bold);
        e.test();

    }
}
