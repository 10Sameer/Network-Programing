import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 8088;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println(" Server is waiting for Sameer...");

            Socket socket = serverSocket.accept();
            System.out.println(" Sameer connected!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

       