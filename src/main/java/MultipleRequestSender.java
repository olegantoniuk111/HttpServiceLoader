import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultipleRequestSender {

    private ExecutorService service;
    private List<Callable<Boolean>> requestsThreads;
    private List<Future<Boolean>> responseResult;
    private int requestQuantity;
    public MultipleRequestSender() throws IOException {
        requestQuantity = Integer.valueOf(PropsHandler.getPropertiesByKey("requestQuantity"));
        service = Executors.newFixedThreadPool(requestQuantity);
    }

    public List<Future<Boolean>> sendMultipleRequest() throws IOException {
        requestsThreads = new ArrayList<Callable<Boolean>>();
        responseResult = new ArrayList<Future<Boolean>>();

        for(int i=1; i<=requestQuantity; i++){
            requestsThreads.add(new RequestSender(i));

        }
        try {
            service.invokeAll(requestsThreads);

            service.shutdown();
            if(service.awaitTermination(100, TimeUnit.MILLISECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseResult;

    }

}


