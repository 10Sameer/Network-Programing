import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String serverIP = "192.168.1.83"; 
        int port = 5001;

        try (Socket socket = new Socket(serverIP, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println("Hello from Client!");
            String response = in.readLine();
            System.out.println("Server replied: " + response);

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
