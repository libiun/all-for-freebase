package basic.net;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class URLConnection2 {
    public static void main(String[] args) throws Exception {
        URL url=new URL("http://www.google.com.hk");
        InputStream is=url.openStream();  //直接使用url的方法获取输入流
        OutputStream os=new FileOutputStream("resource/google.html",true);

        int length;
        byte buffer[]=new byte[1024];
        while(-1 !=(length=is.read(buffer, 0, buffer.length))){
            os.write(buffer, 0, length);
        }

        is.close();
        os.close();

    }
}
