import java.net.*;

public class NetworkInfoPractical1 {
    // Getter method to fetch IP address
    public static String getIPAddress() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            return localHost.getHostAddress();
        } catch (Exception e) {
            return "Could not retrieve IP address.";
        }
    }

    // Getter method to fetch MAC address
    public static String getMACAddress() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(localHost);

            if (network != null) {
                byte[] macAddress = network.getHardwareAddress();
                if (macAddress != null) {
                    StringBuilder macStr = new StringBuilder();
                    for (int i = 0; i < macAddress.length; i++) {
                        macStr.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
                    }
                    return macStr.toString();
                }
            }
            return "MAC Address not found.";
        } catch (Exception e) {
            return "Could not retrieve MAC address.";
        }
    }

    public static void main(String[] args) {
        System.out.println("IP Address: " + getIPAddress());
        System.out.println("MAC Address: " + getMACAddress());
    }
}
