import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

public class DaytimeClient {
    public static void main(String[] args) {
        String hostname = "time.nist.gov"; // Not ntppool.org (it's not a socket server)
        int port = 13; // Daytime service uses port 13

        try (Socket socket = new Socket(hostname, port)) {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            String response;
            while ((response = reader.readLine()) != null) {
                System.out.println("Server Responsed: " + response);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
