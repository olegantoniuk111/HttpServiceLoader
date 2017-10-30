
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    private static List<Future<Boolean>> requestResults;
    public static void main(String[] args) throws IOException {

    sendHttpRequest();
        }

        private static void sendHttpRequest() throws IOException {
        MultipleRequestSender sender = new MultipleRequestSender();
        requestResults = sender.sendMultipleRequest();
//        requestResults.stream().forEach(a -> {
//            try {
//                System.out.println(a.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });

        }
}
