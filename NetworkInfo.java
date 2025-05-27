import java.net.InetAddress;
import java.net.NetworkInterface;

public class NetworkInfo {
    public static void main(String[] args) {
        try {
            // Get the local IP address
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP Address: " + ip.getHostAddress());

            // Get the network interface associated with the IP
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
