package basic.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerOutputThread extends Thread {

    private Socket socket;

    public ServerOutputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();
                os.write(line.getBytes());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
