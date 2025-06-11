import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

public class LowPortScanner {

    public static void main(String[] args) {
        System.out.println("Scanning TCP and UDP ports (1-1024) on localhost...\n");

        for (int port = 1; port <= 1024; port++) {
            if (isTCPPortOpen(port)) {
                System.out.println("TCP Port " + port + " is OPEN");
            }
            if (isUDPPortOpen(port)) {
                System.out.println("UDP Port " + port + " is OPEN");
            }
        }

        System.out.println("\nScan complete.");
    }

    // Method to check if a TCP port is open
    public static boolean isTCPPortOpen(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true);
            return false; // Not open (we were able to bind, so nothing else is using it)
        } catch (IOException e) {
            return true; // Port is in use
        }
    }

    // Method to check if a UDP port is open
    public static boolean isUDPPortOpen(int port) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            datagramSocket.setReuseAddress(true);
            return false; // Not open
        } catch (IOException e) {
            return true; // Port is in use
        }
    }
}
