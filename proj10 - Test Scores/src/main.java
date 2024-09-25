import java.util.Scanner;


/**
 * Main class. Handles program execution
 * Note: I know that main should be in TestScores.java, but for modularity's sake I figured it would be better to have a separate driver file
 * @author Dominic Cronauer
 */
public class main {
    /**
     * Method to handle program execution
     * @param args command line arguments
     */
    public static void main(String[] args) {
        TestScores testScores = new TestScores();//make a TestScores instance to store the Assignment instances
        Scanner sc = new Scanner(System.in); //create a scanner
        String assignmentName;
        int totalTestScore;
        float actualTestScore; //temp variables
        while(true){
            //get name
            System.out.println("Enter assignment name (\"stop\" to stop):");
            assignmentName = sc.nextLine();
            if(assignmentName.equals("stop"))
                break;
            //get tot possible score
            System.out.println("Enter assignment's total possible score:");
            totalTestScore = sc.nextInt();
            //get user's score
            System.out.println("Enter user's score:");
            actualTestScore = sc.nextFloat();
            sc.nextLine();//eat newline
            //exception handling
            try {
                //create new assignment instance
                Assignment assignment = new Assignment(assignmentName, actualTestScore, totalTestScore);
                testScores.AddAssignment(assignment); // add entry to TestScore's Assignment list
            } catch (InvalidPossibleScoreException e) {
                System.out.println("ERROR: THE POINTS POSSIBLE IS INVALID\n");
            } catch (InvalidScoreEarnedException e) {
                System.out.println("ERROR: THE POINTS EARNED IS INVALID\n");
            }
        }
        //output each assignment and its score
        testScores.OutputScores();
        //output averages
        System.out.println(testScores.CalculateAverage());
        sc.close();//close scanner
    }
}
