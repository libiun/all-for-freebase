package basic.javaio;
//
import java.io.*;

/**
 * public class SequenceInputStream
 * extends InputStream
 *
 * SequenceInputStream 表示其他输入流的逻辑串联。它从输入流的有序集合开始，
 * 从第一个输入流开始读取，直到到达文件末尾，接着从第二个输入流读取，
 * 依次类推，直到到达包含的最后一个输入流的文件末尾为止。
 */
public class SequenceInputStreamDemo {

    public static void main(String a[]) {
        try {
            FileInputStream fis1 = new FileInputStream("resource/hello.txt");
            FileInputStream fis2 = new FileInputStream("resource/helloto.txt");
            SequenceInputStream seqinstream = new SequenceInputStream(fis1, fis2);

            BufferedReader br = new BufferedReader(new InputStreamReader(seqinstream));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            // public String readLine() throws IOException
            // 读取一个文本行。通过下列字符之一即可认为某行已终止：换行 ('\n')、回车 ('\r') 或回车后直接跟着换行。
            // 返回： 包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
