package ex4_concurrency;

import java.util.concurrent.BlockingQueue;



public class BarcodeWorker implements Runnable{

    private BlockingQueue<String> queue;
    private String workerId;


    public BarcodeWorker(BlockingQueue<String> queue, String workerId){

        this.queue = queue; 
        this.workerId = workerId;

    }

    @Override 
    public void run() {

        while (true) {
            
        
        //System.out.println("Thread running");

        try {
        String barcode = queue.take();
        System.out.println("["+ workerId+"] "+"Started processing: " + barcode);
        Thread.sleep(800);
        System.out.println("["+ workerId+"] "+"Finished processing: " + barcode);
        } catch (InterruptedException e) {

            System.out.println("Caught interrupted exception" + e);
            break;

        }

        }
    }

}
