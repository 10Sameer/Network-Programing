import java.net.*;
import java.util.*;

public class NetworkInterfacesList {
    public static void main(String[] args) {
        try {
            // Get all network interfaces
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            if (networkInterfaces == null) {
                System.out.println("No network interfaces found.");
                return;
            }

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Interface: " + networkInterface.getName());

                // Get all IP addresses associated with the interface
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    String addressFamily = (inetAddress instanceof Inet4Address) ? "IPv4" : (inetAddress instanceof Inet6Address) ? "IPv6" : "Unknown";
                    System.out.println("  Address: " + inetAddress.getHostAddress() + " | Family: " + addressFamily);
                }
                System.out.println();
            }
        } catch (SocketException e) {
            System.out.println("Error retrieving network interfaces: " + e.getMessage());
        }
    }
}
