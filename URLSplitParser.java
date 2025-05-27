public class URLSplitParser {
    public static void main(String[] args) {
        // Example URL
        String url = "https://www.example.com:8080/path/to/resource?query=value#section";

        // Split protocol and the rest
        String[] protocolSplit = url.split("://");
        String protocol = protocolSplit[0];
        String remainder = protocolSplit[1];

        // Split host and path
        String[] hostSplit = remainder.split("/", 2);
        String hostPort = hostSplit[0];
        String path = "/" + (hostSplit.length > 1 ? hostSplit[1] : "");

        // Split host and port if port is specified
        String host;
        String port = "default";
        if (hostPort.contains(":")) {
            String[] hostPortSplit = hostPort.split(":");
            host = hostPortSplit[0];
            port = hostPortSplit[1];
        } else {
            host = hostPort;
            port = protocol.equals("https") ? "443" : "80"; // Default ports
        }

   
    }
}
