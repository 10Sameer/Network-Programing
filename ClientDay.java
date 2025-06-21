import java.io.*;
import java.net.*;

public class ClientDay {
    public static void main(String[] args) {
        String serverAddress = "192.168.1.83";
        int port = 5000;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
