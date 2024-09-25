import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class MyProg handles program execution
 * @author Dominic Cronauer
 */
public class MyProg {
    /**
     * Method main handles program execution
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LinkedList<String> buffer = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        //get file path
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        scanner.close();//close the scanner (no longer used)
        //create the threads
        ConsumerThread consumerThread = new ConsumerThread(buffer);
        ProducerThread producerThread = new ProducerThread(filePath, buffer, consumerThread);
        //start the threads
        producerThread.start();
        consumerThread.start();
        //wait for threads to die (error if something goes wrong)
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}