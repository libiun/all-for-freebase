package basic.javaio;

import java.io.*;

public class BufferedWriterDemo {

    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resource/streamReader.txt")));
            String s;

            System.out.println("请输入内容：");
            while ((s = br.readLine()) != null) {
                //读取一个文本行。通过下列字符之一即可认为某行已终止：换行 ('\n')、回车 ('\r') 或回车后直接跟着换行。
                //返回：包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
                if (s.endsWith("#")) {
                    bw.write(s, 0, s.length() - 1);
                    bw.newLine();
                    bw.flush();
                    break;
                } else {
                    bw.write(s);
                    bw.newLine();
                    bw.flush();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
