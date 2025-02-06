import java.net.*;

public class Get {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            InetAddress address2 = InetAddress.getByName("8.8.8.8");
            System.out.println("IP Address: " + address2.getCanonicalHostName());
            System.out.println("Host Name: " + address.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Could not find this computer's address.");
        }
    }
}