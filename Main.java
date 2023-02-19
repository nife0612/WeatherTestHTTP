import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

//        String hostName = "httpbin.org";
//        String httpVersion = "HTTP/1.1";
//        String URL = "";

        String hostName = "api.openweathermap.org";
        String httpVersion = "HTTP/1.1";
        String CITY_KEY = "London";
        String API_KEY = "1dccebe5d8cf123057347590b7e1e1c6"; // Insert a valid key
        String url = "/data/2.5/weather?q="+ CITY_KEY + "&appid=" + API_KEY;

        byte[] data = ("GET /" + url + " " + httpVersion + "\n"
                + "Host:" + hostName + "\n\n").getBytes();


        Socket socket = new Socket(hostName, 80);

        InputStream response  = socket.getInputStream();
        OutputStream request = socket.getOutputStream();

        request.write(data);

        int c;

        while((c = response.read()) != -1){
            System.out.print((char) c);
        }

        socket.close();
    }

}
