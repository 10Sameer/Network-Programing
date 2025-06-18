import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 8088;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println(" Connected to server as Sameer");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Sameer sends message
                System.out.print("Sameer: ");
                String msg = keyboard.readLine();
                output.println(msg);

                if (msg.equalsIgnoreCase("bye")) {
                    System.out.println("You left the chat.");
                    break;
                }

                // Wait for server response
                String serverReply = input.readLine();
                if (serverReply == null || serverReply.equalsIgnoreCase("bye")) {
                    System.out.println("Server ended the chat.");
                    break;
                }
                System.out.println("Server: " + serverReply);
            }

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
