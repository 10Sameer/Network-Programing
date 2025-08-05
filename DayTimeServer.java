import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.concurrent.*;

public class DayTimeServer {
    public static void main(String[] args) throws Exception {
        int port = 5000;
        ServerSocket serverSocket = new ServerSocket(port);

        // Show server IP address
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println("DayTime Server started at IP: " + ip + " on port: " + port);

        // Create a thread pool with 5 threads
        ExecutorService pool = Executors.newFixedThreadPool(5);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            pool.execute(new DayTimeHandler(clientSocket));
        }
    }
}

class DayTimeHandler implements Runnable {
    private Socket socket;

    public DayTimeHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String currentTime = LocalDateTime.now().toString();
            out.println("Current Date & Time from Server: " + currentTime);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
