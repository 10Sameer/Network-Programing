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

         