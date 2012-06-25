package basic.javaio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java.lang.Object
 *   java.io.OutputStream
 *      java.io.FileOutputStream
 *
 */
public class FileInputStreamDemo {

    public void readOneEach(String filename) {
        try {
            FileInputStream fileinstream = new FileInputStream(new File(filename));
            //使用循环，从文件开始位置读取字节，每次读取一个
            int b = 0;
            while (-1 != (b = fileinstream.read())) {
                System.out.print((char) b);
            }
            fileinstream.close();
        } catch (Exception ex) {
            Logger.getLogger(FileInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readArrayEach(String filename) {
        try {
            FileInputStream fileinstream = new FileInputStream(new File(filename));
            //使用循环，每次读数组
            int b = 0;
            byte[] ba = new byte[1024];
            while (-1 != (b = fileinstream.read(ba))) {
                //read(byte[] b) 方法把数据读入到byte[]数组中
                for (int i = 0; i < ba.length; i++) {
                    System.out.print((char) ba[i]);
                }
            }
            fileinstream.close();
        } catch (Exception ex) {
            Logger.getLogger(FileInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        FileInputStreamDemo f = new FileInputStreamDemo();
        f.readOneEach("resource/hello.txt");
        f.readArrayEach("resource/hello.txt");
    }
}
