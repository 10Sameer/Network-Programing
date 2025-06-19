import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class DaytimeServer {
    public static void main(String[] args) {
        String lanIP = "192.168.1.83"; 
        int port = 5055; 

        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(lanIP, port));
            System.out.println(" Daytime Server started at " + lanIP + ":" + port);

          
