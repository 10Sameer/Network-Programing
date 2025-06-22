import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        final String SERVER_HOST = "localhost";
        final int SERVER_PORT = 9999;

        try {
            DatagramSocket socket = new DatagramSocket();

            // Send dummy request
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);
            byte[] sendData = {1};  
            DatagramPacket requestPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
            socket.send(requestPacket);

            // Receive server's response
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server Date & Time: " + response);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
