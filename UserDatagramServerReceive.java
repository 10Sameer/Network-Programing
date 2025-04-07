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

      