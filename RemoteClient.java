import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClient{
    public static void main(String[] args) {
        try {
            // Connect to registry at localhost
            Registry registry = LocateRegistry.getRegistry("localhost");

            // Lookup the remote object
            Hello stub = (Hello) registry.lookup("HelloService");

            // Call the remote method
            String response = stub.sayHello();
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
