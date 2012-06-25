package basic.net;

import java.net.URL;

public class Url1 {
    public static void main(String[] args) throws Exception {
        URL url=new URL("http://127.0.0.1:80/file/down#achor");
        String protocal=url.getProtocol();
        String host=url.getHost();
        String file=url.getFile();
        int port=url.getPort();
        String ref=url.getRef();

        System.out.println(protocal+","+host+","+file+","+port+","+ref);
    }
}

