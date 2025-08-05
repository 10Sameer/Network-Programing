import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 9090;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println(" Server is waiting for Sameer...");
            System.out.println(" Sameer connected!");

            while (true) {
                String clientMsg = input.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Sameer has left the chat.");
                    break;
                }
                System.out.println("Sameer: " + clientMsg);

                System.out.print("You: ");
                String serverMsg = keyboard.readLine();
                output.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("bye")) {
                    System.out.println("You ended the chat.");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
