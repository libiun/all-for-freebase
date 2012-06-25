package basic.javaio;
//
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//public final class Scanner
//extends Object
//implements Iterator<String>
//一个可以使用正则表达式来解析基本类型和字符串的简单文本扫描器。
public class ScannerDemo {

    public void methodOne() {
        //Scanner(String source) 构造一个新的 Scanner，它生成的值是从指定字符串扫描的。
        //useDelimiter方法自定义分隔符,默认是空格 \s
        Scanner scanner = new Scanner("1,this is a string,and test").useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.print(scanner.next());
        }
        scanner.close();
    }

    public void methodTwo() {
        try {
            //Scanner(File source) 构造一个新的 Scanner，它生成的值是从指定文件扫描的。
            //定义分隔符为 \n 换行
            Scanner scanner = new Scanner(new File("resource/hello.txt")).useDelimiter("\\n");
            while (scanner.hasNext()) {
                System.out.print(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScannerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void methodThree() {
        try {
            // Scanner(InputStream source) 构造一个新的 Scanner，它生成的值是从指定的输入流扫描的。
            FileInputStream fis = new FileInputStream(new File("resource/hello.txt"));
            Scanner scanner = new Scanner(fis).useDelimiter("\\n");
            while (scanner.hasNext()) {
                System.out.print(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScannerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) {
        ScannerDemo sd = new ScannerDemo();
        sd.methodThree();
    }
}
