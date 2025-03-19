import java.net.URI;
import java.net.URISyntaxException;

public class practical6 {
    public static void parseURL(String url) {
        try {
            URI uri = new URI(url);
            System.out.println("URL: " + url);
            System.out.println("Protocol: " + uri.getScheme());
            System.out.println("User Info: " + uri.getUserInfo());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
            System.out.println();
        } catch (URISyntaxException e) {
            System.out.println("Invalid URL: " + url);
        }
    }

    public static void main(String[] args) {
        parseURL("http://www.example.com:80/index.html");
        parseURL("ftp://mp3:mp3@138.247.121.61:21000/c%3a/");
    }
}
