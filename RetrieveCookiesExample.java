import java.net.*;
import java.io.*;

public class RetrieveCookiesExample {
    public static void main(String[] args) throws Exception {
        // URL to retrieve cookies from
        URL url = new URL("http://example.com");
        
        // Open connection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        // Get cookies sent by the server
        conn.setRequestProperty("Cookie", "user=JohnDoe; session=abc123");
        
        // Retrieve cookies from response headers
        String cookies = conn.getHeaderField("Set-Cookie");
        
        // Print out cookie information
        if (cookies != null) {
            System.out.println("Cookies: " + cookies);
        } else {
            System.out.println("No cookies found.");
        }
    }
}
