import java.net.*;

public class hostIPFinderPractical3 {
    // Method to get IP address of a given hostname
    public static void getIPAddress(String hostName) {
        try {
            InetAddress address = InetAddress.getByName(hostName);
            System.out.println("Host: " + hostName);
            System.out.println("IP Address: " + address.getHostAddress());
            System.out.println("---------------------------");
        } catch (UnknownHostException e) {
            System.out.println("Could not find IP for: " + hostName);
        }
    }

    public static void main(String[] args) {
        // Given hostnames
        String[] hostNames = {"www.scst.edu.np", "www.google.com", "www.facebook.com"};

        // Get and print IP address for each host
        for (String host : hostNames) {
            getIPAddress(host);
        }
    }
}
