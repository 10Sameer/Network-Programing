import java.net.URL;

public class URLComparison {
    public static void compareURLs(String url1, String url2) {
        try {
            URL u1 = new URL(url1);
            URL u2 = new URL(url2);
            
            System.out.println("Comparing: " + url1 + " and " + url2);
            System.out.println("Hosts are same: " + u1.getHost().equals(u2.getHost()));
            System.out.println();
        } catch (Exception e) {
            System.out.println("Invalid URL(s)");
        }
    }


