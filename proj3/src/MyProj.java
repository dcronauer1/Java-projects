import java.util.Scanner;
/*
  URLs:
  Scanner Class: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 */

/**
 * MyProj.java
 * A class to collect user inputs for two linear equations, and to check if and where they intercept.
 *
 * @author Dominic Cronauer
 */
public class MyProj {
    /**
     * function main begins with program execution
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        LinearEquation linearEquation1;
        LinearEquation linearEquation2;

    //P&R values
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the slope of Linear Equation 1?");
        double m1 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("What is the y-intercept of Linear Equation 1?");
        double b1 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("What is the slope of Linear Equation 2?");
        double m2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("What is the y-intercept of Linear Equation 2?");
        double b2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

    //Instantiate objects
        linearEquation1 = new LinearEquation(m1, b1);
        linearEquation2 = new LinearEquation(m2, b2);

    //Find result
        if (linearEquation1.getM() == linearEquation2.getM()) { //check if they are equal or parallel
            if (linearEquation1.getB() == linearEquation2.getB()) {
                System.out.println("The lines are the same.");
            }
            else {System.out.println("The lines are parallel and do not intersect.");}
        }
        else {
            double[] intersection = linearEquation1.computeIntercept(linearEquation2); // compute intersection
            System.out.println("The lines intersect at: (" + intersection[0] + ", " + intersection[1] + ")");
        }
        scanner.close();
    }
}