import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6200); // Create server socket on port 5000
            System.out.println("Server started . Waiting for client...");
            Socket socket = serverSocket.accept(); // Accept client connection
            System.out.println("Client connected.");

            // Input and Output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;
            while (true) {
                clientMessage = input.readLine(); // Read message from client
                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client: " + clientMessage);

                System.out.print("Server: ");
                serverMessage = keyboard.readLine(); // Read server's response
                output.println(serverMessage);
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

               