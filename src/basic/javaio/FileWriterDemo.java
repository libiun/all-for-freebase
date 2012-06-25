package basic.javaio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        File f = new File("resource/helloto.txt");
        try {
            FileWriter fw = new FileWriter(f);
            while (scan.hasNext()) {
                String line = scan.next();
                fw.write(line);
                fw.write('\n');
                if (line.endsWith("#")) {
                    break;
                }
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            FileReader fr = new FileReader(f);
            //因为FileReader默认读取字符流，可以处理中文
            int n = 0;
            while ((n = fr.read()) != -1) {
                System.out.print((char) n);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
