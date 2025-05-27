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

        System.out.println("URL: " + url);
        System.out.println("Protocol: " + protocol);
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Path: " + path);

        // Optional: Extract query and fragment
        String query = "";
        String fragment = "";

        if (path.contains("?")) {
            String[] pathQuerySplit = path.split("\\?", 2);
            path = pathQuerySplit[0];
            String[] queryFragmentSplit = pathQuerySplit[1].split("#", 2);
            query = queryFragmentSplit[0];
            if (queryFragmentSplit.length > 1) {
                fragment = queryFragmentSplit[1];
            }
        } else if (path.contains("#")) {
            String[] pathFragmentSplit = path.split("#", 2);
            path = pathFragmentSplit[0];
            fragment = pathFragmentSplit[1];
        }

        System.out.println("Parsed Path: " + path);
        System.out.println("Query: " + query);
        System.out.println("Fragment: " + fragment);
    }
}
