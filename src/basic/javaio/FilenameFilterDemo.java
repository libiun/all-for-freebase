package basic.javaio;

import java.io.*;

/**
 * 定义Filter 类，实现FilenameFilter接口
 * 用于过滤指定目录下的文本文件(.txt)
 *
 */
//class Filter implements FilenameFilter {
//
//    @Override
//    public boolean accept(File dir, String name) {
//        if (dir != null && name.endsWith(".exe")) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//}
public class FilenameFilterDemo {

    public static void main(String args[]) {
        File file = new File("c:/windows");
        //原来用自定义类new Filter(),现在改为用匿名内部类
        File[] filename = file.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if (null != dir && name.endsWith(".dll")) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        System.out.println("c:\\windows 下的dll文件有：");
        for (File f : filename) {
            System.out.println(f);
        }
    }
}
