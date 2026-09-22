package ex4_concurrency;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            
            if (input.equalsIgnoreCase("exit")||input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("done")){
                System.out.println("[Dispatcher] Stopping input. Awaiting remaining queue processing.");
                scanner.close();

                //2 workers - 2 poison pills 
                queue.put("STOP");
                queue.put("STOP");
                break;
            }

            else {

                queue.put(input);
                System.out.println("[Dispatcher] Staged: "+ input);

            }
            
            
        } catch (InterruptedException e) {
            
            System.out.println("Caught Interruptex Exception: "+ e);
            scanner.close();
            break;
        }
            
        }

        while (!queue.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
               
                System.out.println("Caught Interruptex Exception: "+ e);
            }
        }

         
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Caught Interruptex Exception: "+ e);
        }
        System.out.println("FNISHED ALL PROCESSES");

        

        

    }
    
}
