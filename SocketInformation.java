import java.net.Socket;

public class SocketInformation {
    public static void show(Socket socket) {
        System.out.println(" Socket Information: /n");
        System.out.println("  Local IP      : " + socket.getLocalAddress().getHostAddress());
        System.out.println("  Local Port    : " + socket.getLocalPort());
        System.out.println("  Server IP     : " + socket.getInetAddress().getHostAddress());
        System.out.println("  Server Port   : " + socket.getPort());
        System.out.println("-----------------------------\n");
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("192.168.1.83", 5052)) {
            System.out.println("Testing SocketInformation :5050");
            show(socket);
        } catch (Exception e) {
            System.out.println(" Could not connect: " + e.getMessage());
        }
    }
}
