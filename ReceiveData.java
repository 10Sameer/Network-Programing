import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.IOException;

public class ReceiveData {
    public static void main(String[] args) throws IOException {
        DatagramSocket dsoc = new DatagramSocket(1234);
        byte[] buf = new byte[1024];
        // Created a byte array for receiving data
        DatagramPacket dpac = new DatagramPacket(buf, buf.length);
        
        dsoc.receive(dpac);  // Receive the data into the packet
        String str = new String(dpac.getData(), 0, dpac.getLength());  // Convert byte data to String
        System.out.println(str);  // Print the received message
        
        dsoc.close();  // Close the socket after use
    }
}
