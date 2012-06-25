package basic.javaio;

import java.io.*;

/**
 * 提高内存和程序间交流数据，避免资源浪费
 * java.lang.Object
 *    java.io.InputStream
 *      java.io.FilterInputStream
 *          java.io.BufferedInputStream
 */
public class BufferedInputStreamDemo {
    //处理比较大的文件时起作用,本例使用系统中两个音乐文件作为例子

    public static void copyBigFile(File filefrom, File fileto) {
        FileInputStream fileinstream = null;
        BufferedInputStream bufferedinstream = null;
        BufferedOutputStream bufferedoutstream = null;
        FileOutputStream fileoutstream = null;

        try {
            //这四个对象的创建顺序要注意
            fileinstream = new FileInputStream(filefrom);
            bufferedinstream = new BufferedInputStream(fileinstream, 1024);   //指定流的大小
            fileoutstream = new FileOutputStream(fileto);  //可以带true参数，不过不是文本文件无意义
            bufferedoutstream = new BufferedOutputStream(fileoutstream, 1024);


            int i = 0;
            byte[] bArray = new byte[1024];
            while ((i = bufferedinstream.read(bArray)) != -1) {
                //注意bufferedOutputStream 的write方法的参数的不同
                bufferedoutstream.write(bArray, 0, i);
            }
            bufferedoutstream.flush();
            System.out.println("文件【" + filefrom.getName() + "】已经成功复制到【" + fileto.getName() + "】中。");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedoutstream.close();
                fileoutstream.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String args[]) {
        try {
            File filefrom = new File("e:/baby.mp3");
            File fileto = new File("e:/baby_to2.mp3");
            if (!fileto.exists()) {
                fileto.createNewFile();
            }
            BufferedInputStreamDemo.copyBigFile(filefrom, fileto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
