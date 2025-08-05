import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSender {
    public static void main(String[] args) throws Exception {
        String message = "HELLO";
        int port = 12345;
        String group = "230.0.0.0"; // Multicast IP

        DatagramSocket socket = new DatagramSocket();
        InetAddress groupAddress = InetAddress.getByName(group);

        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, groupAddress, port);
        socket.send(packet);
        System.out.println("Message sent to multicast group: " + message);

        socket.close();
    }
}
