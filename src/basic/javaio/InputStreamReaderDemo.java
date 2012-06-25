package basic.javaio;

import java.io.*;
//System.in->InputStreamReader->OutputStreamWriter->OutputStreamWriter
public class InputStreamReaderDemo {

    public static void main(String[] args) {
        //BufferedReader br=new BufferedReader(InputStreamReader)提高性能
        //从system.in读入字节流转换成字符流
        InputStreamReader isr = null;
        isr = new InputStreamReader(System.in);
        //isr = new InputStreamReader(System.in,"8859_1");
        char[] cbuf = new char[128];

        try {

            FileOutputStream fos = new FileOutputStream("resource/InputStreamReaderDemo.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            System.out.println("请输入内容：");
            int n = 0;
            While:
            while ((n = isr.read(cbuf)) != -1) {
                //inputstream的read方法的参数容易产生错觉。其实不是读取参数的内容，而是写入到参数中
                for (int i = 0; i < n; i++) {
                    if (cbuf[i] == '#') {
                        break While;
                        //跳出整个循环，直接到close处
                    } else if (cbuf[i] == '\n') {
                        osw.write('\n');
                        continue While;
                        //continue跳出本次循环，进行下一个循环，这里跳到标签While处，不会执行osw.write语句
                    }

                    osw.write(cbuf[i]);
                }
            }
            osw.close();
            fos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
