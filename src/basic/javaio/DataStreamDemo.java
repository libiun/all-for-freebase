package basic.javaio;

import java.io.*;
import java.util.Scanner;

/**处理基本数据类型int,float等，无需转换
 *java.lang.Object
 * java.io.InputStream
 *    java.io.FilterInputStream
 *       java.io.DataInputStream
 *
public final class Scanner extends Object implements Iterator<String>
一个可以使用正则表达式来解析基本类型和字符串的简单文本扫描器。
Scanner 使用分隔符模式将其输入分解为标记，默认情况下该分隔符模式与空白匹配。
然后可以使用不同的 next 方法将得到的标记转换为不同类型的值。
例如，以下代码使用户能够从 System.in 中读取一个数：
Scanner sc = new Scanner(System.in);
int i = sc.nextInt();
再看一个例子，以下代码使 long 类型可以通过 myNumbers 文件中的项分配：
Scanner sc = new Scanner(new File("myNumbers"));
while (sc.hasNextLong()) {
long aLong = sc.nextLong();
}
扫描器还可以使用不同于空白的分隔符。下面是从一个字符串读取若干项的例子：

String input = "1 fish 2 fish red fish blue fish";
Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
System.out.println(s.nextInt());
System.out.println(s.nextInt());
System.out.println(s.next());
System.out.println(s.next());
s.close();

输出为：
1
2
red
blue
 **/
public class DataStreamDemo {

    public static void main(String args[]) throws FileNotFoundException, IOException {

        FileDemo.createNewFile("resource/datastreamdemo.txt");
        File file = new File("resource/datastreamdemo.txt");

        FileOutputStream fileoutstream = new FileOutputStream(file);
        DataOutputStream dataoutstream = new DataOutputStream(fileoutstream);
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数据：");
        try {
            dataoutstream.writeBoolean(scan.nextBoolean());
            //dataoutstream.writeByte(scan.nextByte());
            //dataoutstream.writeChar('A');
            //dataoutstream.writeDouble(scan.nextDouble());
            //dataoutstream.writeFloat(scan.nextFloat());
            dataoutstream.writeInt(scan.nextInt());
            //dataoutstream.writeLong(scan.nextLong());
            //dataoutstream.writeShort(scan.nextShort());
        } finally {
            dataoutstream.close();
        }

        FileInputStream fileinstream = new FileInputStream(file);
        DataInputStream datainstream = new DataInputStream(fileinstream);
        try {
            System.out.println("读取boolean数据：" + datainstream.readBoolean());
            System.out.println("读取boolean数据：" + datainstream.readInt());
        } finally {
            datainstream.close();
        }
    }
}
