import wheelsFX.users.Frame.Frame;
import wheelsFX.users.Shapes.Ellipse;
import java.util.Scanner;

/**
 *
 */
public class Avatar {
    private int xcenter;
    private int ycenter;
    private Ellipse ellipse;


    // store variables and objects like above

    /**
     * Constructor that builds avatar at 0,0.
     */
    public Avatar(){
        makeAvatar(0,0);
        xcenter=ycenter=0;
    }
    /**
     * Constructor that builds avatar at x and y coordinates from passed in integers.
     * @param x x coordinate to build avatar at
     * @param y y coordinate to build avatar at
     */
    public Avatar(int x, int y){
        makeAvatar(x,y);
        xcenter=x;
        ycenter=y;
    }
    /**
     * Method to make the avatar at defined x and y coordinates
     * @param x x coordinate to make avatar at
     * @param y y coordinate to make avatar at
     */
    private void makeAvatar(int x, int y) {
        ellipse = new Ellipse(x+10,y);
    }
    /**
     * Set the location of the Avatar to the specified x and y location
     * @param x x location of avatar
     * @param y y location of avatar
     */
    public void setLocation(int x, int y){
        //take everything from make avatar, but fill in x & y centers
    }
    /**
     * Move the Avatar up or down dy pixels
     * @param dy # of pixels to move avatar
     */
    public void moveDown(int dy){

    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Avatar avatar = new Avatar();
        Frame.createFrame();

        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        in.nextLine();
        int y = in.nextInt();
        in.nextLine();
        avatar.setLocation(x,y);



    }

    /*
    Your avatar must have six parts and all must be represented as instance variables.
Your avatar must use at least three colors.
Your avatar must use at least three WheelsFX shapes.
Your avatar cannot be offensive or inappropriate.

In your main method, you will create some Avatar objects and call your methods on them using different values to demonstrate that everything works correctly.

**In addition to the code, you must also create a UML diagram of your class.  This should be saved as a PDF or JPG document for easy viewing and should be separate from your zip file containing your project.
     */
}
