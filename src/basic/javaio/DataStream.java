package basic.javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStream {
    public static void main(String[] args) throws Exception{
        DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("resource/datastream")));
        //dos对象具备了三个功能
        int b=4;
        char ch='a';
        float f=3.4f;
        boolean bl=false;

        dos.writeByte(b);
        dos.writeChar(ch);
        dos.writeFloat(f);
        dos.writeBoolean(bl);
        dos.close();

       //读出文件,按写的顺序读出
        DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream("resource/datastream")));
        System.out.println(dis.readByte());
        System.out.println(dis.readChar());
        System.out.println(dis.readFloat());
        System.out.println(dis.readBoolean());
        dis.close();
    }
}
