import java.net.*;

public class MulticastReceiver {
    public static void main(String[] args) throws Exception {
        int port = 12345;
        String group = "230.0.0.0";

        InetAddress groupAddress = InetAddress.getByName(group);
        MulticastSocket socket = new MulticastSocket(port);

        NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
        socket.joinGroup(new InetSocketAddress(groupAddress, port), netIf);

        byte[] buffer = new byte[1024];
        System.out.println("Waiting for multicast message...");

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received message: " + received);

        socket.leaveGroup(new InetSocketAddress(groupAddress, port), netIf);
        socket.close();
    }
}
