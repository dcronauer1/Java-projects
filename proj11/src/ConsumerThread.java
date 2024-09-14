import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Class to parse a buffer made by ProducerThread to count the number of repeat words found,
 * and to output the most frequent word found.
 * @author Dominic Cronauer
 */
public class ConsumerThread extends Thread {
    private LinkedList<String> buffer;
    private ArrayList<String> words;
    private ArrayList<Integer> frequencies;
    private boolean isProducerDone;
    private String mostFrequentWord;
    private int maxFrequency;
    /**
     * Constructor for ConsumerThread
     * @param buffer buffer to hold words
     */
    public ConsumerThread(LinkedList<String> buffer) {
        this.buffer = buffer;
        this.words = new ArrayList<>();
        this.frequencies = new ArrayList<>();
        this.isProducerDone = false;
    }

    /**
     * Method run() overrides method in Thread class. Called when the thread is started
     */
    public void run() {
        //run while the buffer isn't empty or the producer isn't done
        while (!isProducerDone || !buffer.isEmpty()) {
            String word = null;
            synchronized (buffer) {
                //run while the buffer is empty and the producer isn't done, ie: wait
                while (buffer.isEmpty() && !isProducerDone) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
                //if buffer isn't empty, grab the first word and remove it.
                if (!buffer.isEmpty()) {
                    word = buffer.removeFirst();
                    buffer.notifyAll();
                }
            }
            //tally the word
            if (word != null) {
                addWord(word);
            }
        }
        printMostFrequentWord();//do this when producer is done and the buffer is empty
    }

    /**
     * Method to add a word. Called from the run() method
     * Could do hashing instead, but we haven't learned how to do that in Java yet (if I had more time I would)
     * @param word word to add
     */
    private void addWord(String word) {
        int index = words.indexOf(word);//get the index of the word
        if (index != -1) {
            frequencies.set(index, frequencies.get(index) + 1);//add a tally
            int newFrequency = frequencies.get(index);
            //check if it's a new max word
            if (newFrequency > maxFrequency) {
                maxFrequency = newFrequency;
                mostFrequentWord = word;
            }
        } else {
            words.add(word);
            frequencies.add(1);//add word to the list
            //check if it's a new max word
            if (maxFrequency == 0) {
                maxFrequency = 1;
                mostFrequentWord = word;
            }
        }
    }
    /**
     * Method to print the most frequent word and how many instances there are of it
     */
    private void printMostFrequentWord() {
        System.out.println("Most frequent word: " + mostFrequentWord);
        System.out.println("Frequency: " + maxFrequency);
    }

    /**
     * Method called from ProducerThread to let ConsumerTread know that the producer thread has finished its job
     */
    public void setProducerDone() {
        isProducerDone = true;
        synchronized (buffer) {
            buffer.notifyAll();
        }
    }
}