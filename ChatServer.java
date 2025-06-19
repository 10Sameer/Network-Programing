import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 8090;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println(" Server is waiting for Sameer...");

            Socket socket = serverSocket.accept();
            System.out.println(" Sameer connected!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Wait for Sameer's message
                String clientMsg = input.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Sameer has left the chat.");
                    break;
                }
                System.out.println("Sameer: " + clientMsg);

                // Now server replies
                System.out.print("Server: ");
                String serverMsg = keyboard.readLine();
                output.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("bye")) {
                    System.out.println("The chat has been ended.");
                    break;
                }
            }

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
