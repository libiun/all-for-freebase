package basic.javaio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOutputStreamDemo {


    public static void copyOneFileToAnother(File filefrom, File fileto) {
        FileInputStream fileinstream = null;
        FileOutputStream fileoutstream = null;
        try {
            fileinstream = new FileInputStream(filefrom);
            fileoutstream = new FileOutputStream(fileto, true);
            //true 表示在后面继续添加，否则覆盖原来的。
            byte[] bArrays = new byte[(int) filefrom.length()];
            int i = 0;
            while ((i = fileinstream.read(bArrays)) != -1) {
                fileoutstream.write(bArrays);
            }
            System.out.println("文件【" + filefrom.getName() + "】已经成功复制到【" + fileto.getName() + "】中。");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileoutstream.close();
                fileinstream.close();
            } catch (IOException ex) {
                Logger.getLogger(FileOutputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String args[]) {
        try {
            File filefrom = new File("resource/hello.txt");
            File fileto = new File("resource/helloto.txt");
            if (!fileto.exists()) {
                fileto.createNewFile();
            }
            FileOutputStreamDemo.copyOneFileToAnother(filefrom, fileto);

        } catch (IOException ex) {
            Logger.getLogger(FileOutputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
