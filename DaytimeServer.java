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

            while (true) {
                Socket client = serverSocket.accept();

                // Show connected client IP and port
                System.out.println(" Connected client: " + client.getInetAddress().getHostAddress() 
                                   + ":" + client.getPort());

                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                String now = " Time Now: " + LocalDateTime.now();
                out.println(now);

                System.out.println(" Sent to client: " + client.getInetAddress().getHostAddress() + " → " + now);
                client.close();
            }
        } catch (IOException e) {
            System.err.println(" Server error: " + e.getMessage());
        }
    }
}
