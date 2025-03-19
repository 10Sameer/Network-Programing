// checking last modified date of a file from a URL
// The following program demonstrates how to check the last modified date of a file from a URL.
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class urlHeader{
    public static void main(String[] args) {
        try {
            // Given URL
            URL url = new URL("https://www.example.com/somefile.txt");

            // Open HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");  // Set HEAD request

            // Connect to server
            connection.connect();

            // Get Last-Modified header (in milliseconds since epoch)
            long lastModified = connection.getLastModified();

            if (lastModified == 0) {
                System.out.println("Last-Modified header not found");
            } else {
                // Convert to readable date format
                Date date = new Date(lastModified);
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
                System.out.println("Last Modified: " + formatter.format(date));
            }

            // Close connection
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



