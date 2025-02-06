// Wap to print the IP Address of yours Machine

import java.net.*;
  public class IP{
    public static void main(String[] args) throws UnknownHostException{
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr);
    }
  }
   