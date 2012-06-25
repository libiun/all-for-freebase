package basic.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLConnection3 {

    public static void main(String[] args) throws Exception {
        //必须带上协议名称,
        URL url = new URL("http://www.sohu.com");
        //字节流转字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while (null != (line = br.readLine())) {
            System.out.println(line);
        }
        br.close();
    }
}
