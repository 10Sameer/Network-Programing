
import java.net.*;
import java.io.*;
// Create a URL connection class
public class URLConnectionExample {
public static void main(String[] args) {
try {

URL url = new URL("https://www.example.com");
// Open a connection to the given url
URLConnection urlConnection = url.openConnection();
// Get the input stream from the URL connection which we use to read data from the resources
InputStream inputStream = urlConnection.getInputStream();
// Create a BufferedReader object reader to read the data from input stream
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

String inputLine; 

while ((inputLine = reader.readLine()) != null)
{
System.out.println(inputLine); 
}

reader.close();
} catch (IOException e) {
}
}
}