package ex4_concurrency;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//====================BARCODE DISPATCHER===============
//-Operator
//  [x] Input barcodes from console
//
//-Workers
//  [x] 5 item queue
//  [x] Working concurrently 
//


public class Main {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

        BarcodeWorker firstWorker = new BarcodeWorker(queue, "Worker number One");
        
        BarcodeWorker secondWorker = new BarcodeWorker(queue, "Worker number Two");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(firstWorker);
        executorService.submit(secondWorker);


        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

        String input = scanner.nextLine();
        try {
            
            if (input.equalsIgnoreCase("exit")||input.equalsIgnoreCase("quit")){
                scanner.close();
                break;
            }

            else {

                queue.put(input);
                System.out.println("[Dispatcher] Staged: "+ input);

            }
            
            
        } catch (InterruptedException e) {
            
            System.out.println("Caught exception: "+ e);
            scanner.close();
            break;
        }
            
        }

        

        

    }
    
}
