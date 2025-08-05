import java.io.*;
import java.net.*;

public class DayTimeClient {
    public static void main(String[] args) throws Exception {
        String serverIP = "127.0.0.1"; 
        int port = 5000;

        Socket socket = new Socket(serverIP, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = in.readLine();

        System.out.println("Server Response: " + response);

        socket.close();
    }
}
