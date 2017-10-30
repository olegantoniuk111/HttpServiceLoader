import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;
import java.util.concurrent.Callable;


public class RequestSender implements Callable<Boolean> {
    private String hostName = PropsHandler.getPropertiesByKey("hostName");
    private int i;
    private  URL url = new URL(hostName);



    public RequestSender(int i ) throws IOException {
        this.i = i;
    }

    public Boolean call() throws Exception {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            LocalTime time = LocalTime.now();

            connection.disconnect();
            System.out.println(time +"responseCode" + responseCode );
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
