/**
 * Class to handle incorrect actualTestScore value in Assignment.java
 * @author Dominic Cronauer
 */
public class InvalidScoreEarnedException extends Exception {
    /**
     * Constructs a new InvalidScoreEarnedException with the specified detail message.
     * @param message The detail message.
     */
    public InvalidScoreEarnedException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InvalidScoreEarnedException: " + getMessage();
    }
}
