 import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6200); 
            System.out.println("Connected to server.");

            // Input and Output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;
            while (true) {
                System.out.print("Client: ");
                clientMessage = keyboard.readLine(); // Read client input
                output.println(clientMessage); // Send to server

                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Disconnected from server.");
                    break;
                }

                serverMessage = input.readLine(); // Read server response
                System.out.println("Server: " + serverMessage);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
