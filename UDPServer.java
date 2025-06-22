import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPServer {
    public static void main(String[] args) {
        final int SERVER_PORT = 9999;

        try {
            DatagramSocket socket = new DatagramSocket(SERVER_PORT);
            System.out.println("Daytime UDP Server is running on port " + SERVER_PORT);

            byte[] buffer = new byte[1024];

            while (true) {
                // Receive request
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);

                // Get current date and time
                String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                byte[] timeData = currentTime.getBytes();

         