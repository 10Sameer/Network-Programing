import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Implement the remote interface
public class MyRemoteimpl implements Hello {

    public HelloServer() {}

    public String sayHello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
        try {
            HelloServer obj = new HelloServer();

            // Export the object
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Create RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object's stub in the registry
            registry.rebind("HelloService", stub);

            System.out.println("Server ready. HelloService bound.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
