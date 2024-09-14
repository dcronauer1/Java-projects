/**
 * Accountant.java
 * A class to represent an accountant with a name, age, and company name.
 * Class contains methods to compute and display accountant's salary and details
 *
 * @author Dominic Cronauer
 */
public class Accountant {
    private String name, company;
    private int age;

    /**
     * Constructor for the Accountant class
     * @param n The name of the employee
     * @param a The age of the employee
     * @param c The name of the employee's company
     */
    public Accountant(String n, int a, String c) {
        name = n;
        age = a;
        company = c;
    }

    /**
     * Method for getting the accountant's name
     * @return Accountant's name
     */
    public String getName(){
        return name;
    }

    /**
     * Method for getting the accountant's age
     * @return Accountant's age as an int
     */
    public int getAge(){
        return age;
    }

    /**
     * Method for getting the accountant's company name
     * @return Accountant's company name
     */
    public String getCompany(){
        return company;
    }

    /**
     * Method to get the accountant's salary
     * @return accountant's salary as a double.
     */
    public double getSalary() {
        return 40000 * Math.sqrt(Math.exp(0.04295 * age + 0.141));
    }

    /**
     * Method to display the accountant's salary in a formatted string.
     */
    public void printSalary() {
        double salary = getSalary();
        System.out.printf("Salary: $%.2f%n", salary);
    }

    /**
     * Method to display the accountant's details in a formatted string.
     * Format: Name: name, Age: age, Company Name: company
     */
    public void displayDetails() {
        System.out.printf("Name: %s, Age: %d, Company Name: %s\n", getName(), getAge(), getCompany()); //could also just be System.out.printf("Name: %s, Age: %d, Company Name: %s\n", name, age, company);
    }
}
