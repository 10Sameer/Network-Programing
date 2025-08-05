import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPEchoClient {
    public static void main(String[] args) {
        String serverIP = "localhost"; // Or server IP like "192.168.1.x"
        int port = 9876;

        try {
            DatagramSocket clientSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter message to send: ");
            String message = scanner.nextLine();

            byte[] sendBuffer = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName(serverIP);

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, port);
            clientSocket.send(sendPacket);

            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String echoedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server echoed: " + echoedMessage);

            clientSocket.close();
            scanner.close();

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
