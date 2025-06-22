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

           