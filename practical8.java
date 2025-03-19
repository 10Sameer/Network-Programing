// That block all the cookie from the .gov domain
// This is a simple example of how to use a custom cookie policy to block cookies from a specific domain.
import java.net.*;
import java.io.*;


public class practical8 {
    public static void main(String[] args) throws Exception {
        
        CookiePolicy customPolicy = new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                String host = uri.getHost();
                if (host != null && host.endsWith(".gov")) {
                    return false; 
                }
                return true;  
            }
        };

        CookieManager manager = new CookieManager(null, customPolicy);
        CookieHandler.setDefault(manager);

       
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine); 
        }
        in.close();
    }
}
