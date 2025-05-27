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
    

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
