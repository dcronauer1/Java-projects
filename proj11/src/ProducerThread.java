import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class ProducerThread produces words in the buffer for ConsumerThread to parse
 * @author Dominic Cronauer
 */
public class ProducerThread extends Thread {
    private String filePath;
    private LinkedList<String> buffer;
    private static final int MAX_BUFFER_SIZE = 100;
    private ConsumerThread consumerThread;

    /**
     * Constructor for ProducerThread
     * @param filePath the filepath of the file to be parsed
     * @param buffer buffer to hold words
     * @param consumerThread passed in and used to let ConsumerThread know that ProducerThread is done
     */
    public ProducerThread(String filePath, LinkedList<String> buffer, ConsumerThread consumerThread) {
        this.filePath = filePath;
        this.buffer = buffer;
        this.consumerThread = consumerThread;
    }

    /**
     * Method run() overrides method in Thread class. Called when the thread is started
     */
    public void run() {
        //make sure everything works
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //go line by line
            while ((line = reader.readLine()) != null) {
                //split the line into words
                String[] words = line.split("\\s+");//"\\s+" splits based on whitespace characters, and doesn't care how many there are in a row
                for (String word : words) {
                    //make all letters lowercase for easier comparisons
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        //synchronized block
                        synchronized (buffer) {
                            while (buffer.size() >= MAX_BUFFER_SIZE) {
                                try {
                                    buffer.wait();
                                } catch (InterruptedException e) {
                                    System.out.println(e);
                                }
                            }
                            buffer.add(word);//add word to the buffer
                            buffer.notifyAll();//let other threads know a word was added
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        //Signal that the producer is done
        consumerThread.setProducerDone();
    }
}