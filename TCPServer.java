import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 5001;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

       
