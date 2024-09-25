import java.util.Scanner;

/**
 * proj5.java
 * A class to collect a fraction from user input, find the gcd between both numbers using
 * euclid's algorithm, and output the gcd and a reduced fraction of both numbers
 *
 * @author Dominic Cronauer
 */
public class proj5 {
    /**
     * recursive function using euclid's algorithm
     * @param a first number to use
     * @param b second number to use
     * @return gcd of a and b
     */
    public static int gcd(int a, int b) {
        if (a == 0){return b;}
        return gcd(b % a, a);
    }
    /**
     * function main begins with program execution
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        int a,b,gcd;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numerator");
        a = input.nextInt();
        System.out.println("Enter the denominator");
        b = input.nextInt();

        gcd = gcd(a,b);

        System.out.println("GCD of " + a + "/" + b + " is " + gcd);
        System.out.println("So we have " + a + "/" + b + " = "+a/gcd+"/"+b/gcd);
    }
}

/*--Sample output--
Enter the numerator
124
Enter the denominator
64
GCD of 124/64 is 4
So we have 124/64 = 31/16
 */