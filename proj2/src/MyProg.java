import java.util.Scanner;

/*
  URLs:
  Math Class: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
  Scanner Class: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 */

/**
 * MyProj.java
 * A class to collect user inputs, create an Accountant object, and call its methods.
 *
 * @author Dominic Cronauer
 */
public class MyProg {
    /**
     * function main begins with program execution
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String name, company;
            int age;

        // Collect user input for name, age, and company name
        System.out.println("What is the employee's name?");
        name = scanner.nextLine();

        System.out.println("How old is the employee?");
        age= scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("What is the name of the company?");
        company = scanner.nextLine();

        /*
         //test code
         System.out.println("age = " + age);
         System.out.println("name = " +name);
         System.out.println("company = " +company);
        */

        // Create an Accountant object with the collected inputs
        Accountant accountant = new Accountant(name,age,company);

        accountant.displayDetails(); //Outputs the details of the accountant
        accountant.printSalary(); //Outputs the formatted salary of the accountant

    }
}