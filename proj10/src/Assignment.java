import java.util.ArrayList;

/**
 * Class to store variables for an Assignment. Handles exceptions
 * @author Dominic Cronauer
 */
public class Assignment {
    public String assignmentName;
    public int totalTestScore;
    public float actualTestScore;
    public float weightedScore; // the user's score out of 100 (aka percentage)

    /**
     * Constructor for the Assignment class
     * @param assignmentName Assignment's name
     * @param actualTestScore student's score on the assignment
     * @param totalTestScore highest possible score on the assignment
     * @throws InvalidPossibleScoreException exception for invalid amount of totalTestScore
     * @throws InvalidScoreEarnedException exception for invalid amount of actualTestScore
     */
    public Assignment(String assignmentName, float actualTestScore, int totalTestScore) throws InvalidPossibleScoreException, InvalidScoreEarnedException {
        if (totalTestScore <= 0) {
            throw new InvalidPossibleScoreException("Points possible must be greater than 0.");
        }
        if (actualTestScore < 0 || actualTestScore > totalTestScore) {
            throw new InvalidScoreEarnedException("Points earned must be between 0 and total possible points.");
        }
        this.assignmentName = assignmentName;
        this.totalTestScore = totalTestScore;
        this.actualTestScore = actualTestScore;
        this.weightedScore = (100f / (float) totalTestScore) * actualTestScore; // calculate weight/percentage of Assignment
    }
}