package basic.javaio;

import java.io.*;
//
public class PrintStreamDemo {

    public static void main(String args[]) {
        PrintStream ps = null;
        FileDemo.createNewFile("resource/printstream.txt");
        try {
            ps = new PrintStream(new FileOutputStream(new File("resource/printstream.txt")));
            String name = "Lijun";
            int age = 23;
            float score = 99.5f;
            char sex = 'M';

            ps.printf("姓名：%s；年龄：%d；成绩：%f；性别：%c", name, age, score, sex);
            ps.println();
            ps.println("《Java入门》");
            String s = "作者：李俊";
            byte[] buf = new byte[512];
            buf=s.getBytes();
            ps.write(buf, 0, buf.length);

            System.out.println("写入成功。");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ps.close();
        }
    }
}
