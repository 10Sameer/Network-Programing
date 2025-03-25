import java.net.*;
import java.io.*;

public class ExamplePUTMethod  {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://example.com/api/update");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setDoOutput(true);

        // Send data in the request body
        String data = "name=Sameer&email=Sameer@example.com";
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = data.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        System.out.println("Response Code: " + conn.getResponseCode());
    }
}
