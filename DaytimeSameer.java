import java.io.*;
import java.net.*;

public class DaytimeSameer {
    public static void main(String[] args) {
        String serverIP = "192.168.1.10"; 
        int port = 5055;

        try (Socket socket = new Socket(serverIP, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println(" Hello, Sameer here!");
            String reply = input.readLine();
            System.out.println(" Server replied: " + reply);

            SocketInformation.show(socket);

        } catch (IOException e) {
            System.err.println(" Error connecting: " + e.getMessage());
        }
    }
}
