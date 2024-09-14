/**
 * LinearEquation.java
 * A class to represent a linear equation with a slope (m) and y-intercept (b).
 * Class contains methods to compute and display linear equations' intercept.
 *
 * @author Dominic Cronauer
 */
public class LinearEquation {
    double m,b;
    /**
     * Constructor for the LinearEquation class
     * @param m1 slope of linear eqn
     * @param b1 y-intercept of linear eqn
     */
    public LinearEquation(double m1, double b1) {
        m=m1;
        b=b1;
    }

    /**
     * Method for getting the Linear Equation's slope
     * @return Linear Equation's slope
     */
    public double getM(){
        return m;
    }

    /**
     * Method for getting the Linear Equation's y-intercept
     * @return Linear Equation's y-intercept
     */
    public double getB(){
        return b;
    }

    /**
     * Method to compute the x and y intercept between two linear equations
     * @param linearEquation The second linear equation
     * @return x and y intercept coordinates in an array
     */
    public double[] computeIntercept(LinearEquation linearEquation){
        double x =(linearEquation.getB() - this.getB()) / (this.getM() - linearEquation.getM()); //x=(b2-b1)/(m1-m2)
        double y = this.getM() * x + this.getB(); // solve for y using x
        return new double[]{x, y}; //store coordinates as an array
    }
}
