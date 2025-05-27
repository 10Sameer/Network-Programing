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

            if (network != null) {
                byte[] mac = network.getHardwareAddress();

                if (mac != null) {
                    StringBuilder macAddress = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.println("MAC Address: " + macAddress.toString());
                } else {
                    System.out.println("MAC Address not available.");
                }
            } else {
                System.out.println("Network Interface for the IP not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
