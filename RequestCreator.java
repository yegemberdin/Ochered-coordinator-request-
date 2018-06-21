import java.util.Random;


public class RequestCreator extends Thread {


    private Coordinator coordinator;
    private Random random;
    public static int requestCount = 100;

    public RequestCreator(Coordinator coordinator) {
        this.coordinator = coordinator;
        this.random = new Random();
    }

    public void run () {
        // System.out.println("Request creator started...");
        try {
            while(--requestCount > -1) {
                Request newRequest = new Request(random.nextInt(9000)+1000);                  
                coordinator.addRequest(newRequest);
                
                int waitTime = random.nextInt(1000)+1000;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
