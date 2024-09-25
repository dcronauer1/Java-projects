import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Class to hold a collection of Assignment instances.
 * Can access elements of its Assignment list to perform functions
 * @author Dominic Cronauer
 */
public class TestScores {
    ArrayList<Assignment> assignments;
    public double average,weightedAverage;
    public TestScores(){
        this.assignments = new ArrayList<>();
        this.average=0;
        this.weightedAverage=0;
    }

    /**
     * Method to add an assignment to the Assignment list
     * @param assignment Assignment instance to add to the list
     * @return (OPTIONAL) current Amount of Assignment's stored
     */
    public int AddAssignment(Assignment assignment){
        assignments.add(assignment);
        return assignments.size();
   }

    /**
     * Method to output all collected assignment scores and percentages
     * output is formatted
     */
    public void OutputScores() {
        System.out.println("Assignment Scores: actual/total score,%");
        DecimalFormat ft = new DecimalFormat("#.##");
        for (Assignment assignment : this.assignments) {
            System.out.printf("%-20s %-15s %s\n",
                    assignment.assignmentName + ":",
                    ft.format(assignment.actualTestScore) + "/" + ft.format(assignment.totalTestScore),
                    ft.format(assignment.weightedScore) + "%");
        }
    }

    /**
     * Method to calculate the average and weighted average of all Assignments collected.
     * @return (OPTIONAL) String to display the grades earned
     */
    public String CalculateAverage() {
        int length = this.assignments.size();
        int total=0;
        float userTotal=0,percentTotal=0;
        for(Assignment assignment : this.assignments){
            total += assignment.totalTestScore;
            userTotal += assignment.actualTestScore;
            percentTotal+=assignment.weightedScore;
        }
        this.average=Math.round(100d*(double)percentTotal/(double)length)/100d;//average of each assignment
        this.weightedAverage=Math.round(10000d*(double)userTotal/(double)total)/100d;//true weighted grade
        userTotal=Math.round(100d*userTotal)/100f;
        //optional return
        return "The average grade from each of these assignments is: "+this.average+"%\n"+
        "The grade earned from these assignments is: "+userTotal+"/"+total+" ("+this.weightedAverage+"%)";
    }
}