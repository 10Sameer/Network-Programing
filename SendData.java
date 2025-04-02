import java.io.*;
import java.net.*;

public class SendData {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String str = "message";
        
        byte[] data = str.getBytes(); // Convert string to byte array
        InetAddress ip = InetAddress.getByName("127.0.0.1"); // Localhost IP address
        
        DatagramPacket dp = new DatagramPacket(data, data.length, ip, 1234);
        ds.send(dp); // Send the packet
        
        ds.close(); // Close the socket
    }
}
