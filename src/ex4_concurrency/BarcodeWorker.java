package ex4_concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;


public class BarcodeWorker implements Runnable{

    private BlockingQueue<String> queue;
    private String workerId;


    public BarcodeWorker(BlockingQueue<String> queue, String workerId){

        this.queue = queue; 
        this.workerId = workerId;

    }

    @Override 
    public void run() {

        System.out.println("Thread running");

        try {
        queue.take();
        System.out.println("Starting");
        Thread.sleep(800);
        System.out.println("Ending");
        } catch (InterruptedException e) {

            System.out.println("Caught interrupted exception" + e);

        }

    }



    public class InnerBarcodeWorker {
    
        public static void main(String[] args) {
            


        }
        
    }

}
