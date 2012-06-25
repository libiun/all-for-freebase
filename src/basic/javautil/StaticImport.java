package basic.javautil;
//import basic.staticimport.Common;

import static basic.staticimport.Common.AGE;
import static basic.staticimport.Common.output;
//静态导入basic.staticimport包的东东

public class StaticImport {

    public static void main(String[] args) {
//        int a=Common.AGE;
//        System.out.println(a);
//        Common.output();
        int a = AGE;
        System.out.println(a);
        output();
    }
}
