// UDPClient.java
import java.net.*;
import java.util.Scanner;

public class UserDatagramServerReceive {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter message to send to server: ");
            String message = sc.nextLine();

            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            clientSocket.send(sendPacket);

            // Receive reply from server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String serverReply = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Reply from server: " + serverReply);

            clientSocket.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
