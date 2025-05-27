import java.net.*;

public class Details {
    public static void main(String[] args) {
        try {
            // Replace with any URL you want to test
            String urlString = "https://www.google.com";

            // Convert to URL and then extract host
            URL url = new URL(urlString);
            String host = url.getHost();

            // Resolve host to IP
            InetAddress address = InetAddress.getByName(host);

            System.out.println("URL: " + urlString);
            System.out.println("Host: " + host);
            System.out.println("IP Address: " + address.getHostAddress());

            // Optional: Check reachability
            boolean reachable = address.isReachable(5000); // 5 second timeout
            System.out.println("Is Host Reachable? " + (reachable ? "Yes" : "No"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
