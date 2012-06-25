package basic.net;

import java.net.ServerSocket;
import java.net.Socket;

public class MailServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4000);

        while (true) {
            Socket socket = serverSocket.accept();
            //启动读写线程
            new ServerInputThread(socket).start();
            new ServerOutputThread(socket).start();

        }
    }
}
