import java.net.*;

public class Networking {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress obj1 = InetAddress.getByName("www.example.com");
        InetAddress obj2= InetAddress.getByName("example.com");
        boolean x = obj1.equals(obj2);
        System.out.println("Both hostnames are equal:"+x);
           
    }
}
