//WAP to split/parse the given string into tokens using URL class method.

import java.net.*;

public class splitParse {

    public static void main(String[] args) {
        try {
            // URL url = new URL("https://www.example.com:90/anything/thispage.html?param1=value1#here");
             URL url = new URL("ftp://www.example.com:2121/dir1/dir2/file.text;type=i?key=value#section");
            // Get the protocol used by the URL (in this case, "https")
            System.out.println("Protocol: " + url.getProtocol());
            // Get the host name of the server (in this case, "www.example.com")
            System.out.println("Authority " + url.getAuthority());
            System.out.println("Host: " + url.getHost());
            // Get the port number used by the server (in this case, 90)
            System.out.println("Port: " + url.getPort());
            // Get the path of the resource (in this case, "/anything/thispage.html")
            System.out.println("Path: " + url.getPath());
            // Get the query string of the URL (in this case, "param1=value1")
            System.out.println("Query: " + url.getQuery());
            // Get the fragment identifier of the URL (in this case, "here")
            System.out.println("Fragment: " + url.getRef());
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }
}