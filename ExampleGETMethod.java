import java.net.*;
import javax.net.ssl.*;

public class ExampleGETMethod {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        System.out.println("Response Code: " + conn.getResponseCode());
    }
}
