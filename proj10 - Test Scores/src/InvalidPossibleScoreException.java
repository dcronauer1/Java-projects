/**
 * Class to handle incorrect totalTestScore value in Assignment.java
 * @author Dominic Cronauer
 */
public class InvalidPossibleScoreException extends Exception {
    /**
     * Constructs a new InvalidPossibleScoreException with the specified detail message.
     * @param message The detail message.
     */
    public InvalidPossibleScoreException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InvalidPossibleScoreException: " + getMessage();
    }
}
