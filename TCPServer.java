import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) {
        int port = 9876;

        try {
            DatagramSocket serverSocket = new DatagramSocket(port);
            System.out.println("UDP Echo Server started on port " + port + "...");

            byte[] receiveBuffer = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + clientMessage);

                // Echo the message back to the client
                DatagramPacket sendPacket = new DatagramPacket(
                    receivePacket.getData(),
                    receivePacket.getLength(),
                    receivePacket.getAddress(),
                    receivePacket.getPort()
                );
                serverSocket.send(sendPacket);
            }

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
