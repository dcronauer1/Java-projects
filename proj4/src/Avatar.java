import javafx.scene.paint.Color;
import wheelsFX.users.Frame.Frame;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Triangle;
import wheelsFX.users.Shapes.Rectangle;

/**
 * Avatar.java
 * A class that constructs, makes, and can control the position of an avatar using wheelsFX
 *
 * @author Dominic Cronauer
 */
public class Avatar {
    private int xCenter;
    private int yCenter;
    private Rectangle rectangle1;
    private Ellipse ellipse1, ellipse2, ellipse3, ellipse4;
    private Triangle triangle2, triangle3, triangle1, triangle4;
    private final Color blue = Color.BLUE, orange = Color.ORANGE, red = Color.RED, green = Color.GREEN, black = Color.BLACK, white = Color.WHITE;
    /**
     * Constructor that builds avatar at 0,0.
     */
    public Avatar(){
        makeAvatar(0,0);
        xCenter = yCenter =0;
    }
    /**
     * Constructor that builds avatar at x and y coordinates from passed in integers.
     * @param x x coordinate to build avatar at
     * @param y y coordinate to build avatar at
     */
    public Avatar(int x, int y){
        makeAvatar(x,y);
        xCenter =x;
        yCenter =y;
    }
    /**
     * Method to make the avatar at defined x and y coordinates
     * @param x x coordinate to make avatar at
     * @param y y coordinate to make avatar at
     */
    private void makeAvatar(int x, int y) {
        //create shapes with colors, then set sizes, positions,etc.
        //Everything is centered mathematically, but not graphically
        rectangle1 = new Rectangle(black);
        rectangle1.setSize(170,170);
        rectangle1.setLocation(x-85,y-85);

        triangle1 = new Triangle(white);
        triangle1.setRotation(0);
        triangle1.setSize(20,20);
        triangle1.setLocation(x,y+40);

        triangle2 = new Triangle(white);
        triangle2.setRotation(90);
        triangle2.setSize(20,20);
        triangle2.setLocation(x-40,y);

        triangle3 = new Triangle(white);
        triangle3.setRotation(180);
        triangle3.setSize(20,20);
        triangle3.setLocation(x,y-40);

        triangle4 = new Triangle(white);
        triangle4.setRotation(270);
        triangle4.setSize(20,20);
        triangle4.setLocation(x+40,y);

        ellipse1 = new Ellipse(red);
        ellipse1.setSize(50,50);
        ellipse1.setLocation(x,y);

        ellipse2 = new Ellipse(blue);
        ellipse2.setSize(40,40);
        ellipse2.setLocation(x,y);

        ellipse3 = new Ellipse(green);
        ellipse3.setSize(30,30);
        ellipse3.setLocation(x,y);

        ellipse4 = new Ellipse(orange);
        ellipse4.setSize(20,20);
        ellipse4.setLocation(x,y);
    }
    /**
     * Set the location of the Avatar to the specified x and y location
     * @param x x location of avatar
     * @param y y location of avatar
     */
    public void setLocation(int x, int y){
        rectangle1.setLocation(x-85,y-85);
        triangle1.setLocation(x,y+40);
        triangle2.setLocation(x-40,y);
        triangle3.setLocation(x,y-40);
        triangle4.setLocation(x+40,y);
        ellipse1.setLocation(x,y);
        ellipse2.setLocation(x,y);
        ellipse3.setLocation(x,y);
        ellipse4.setLocation(x,y);
        xCenter =x;
        yCenter =y;
    }
    /**
     * Move the Avatar up or down dy units
     * @param dy # of units to move avatar
     */
    public void moveDown(int dy){
        rectangle1.setLocation(xCenter -85, yCenter -85+dy);
        triangle1.setLocation(xCenter, yCenter +40+dy);
        triangle2.setLocation(xCenter -40, yCenter +dy);
        triangle3.setLocation(xCenter, yCenter -40+dy);
        triangle4.setLocation(xCenter +40, yCenter +dy);
        ellipse1.setLocation(xCenter, yCenter +dy);
        ellipse2.setLocation(xCenter, yCenter +dy);
        ellipse3.setLocation(xCenter, yCenter +dy);
        ellipse4.setLocation(xCenter, yCenter +dy);
        yCenter +=dy;
    }
    /**
     * function main begins with program execution
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Avatar avatar = new Avatar(200,200);
        Avatar avatar2 = new Avatar();
        Avatar avatar3 = new Avatar(600,500);
        System.out.println("avatar:"+avatar.xCenter +","+avatar.yCenter);
        System.out.println("avatar2:"+avatar2.xCenter +","+avatar2.yCenter);
        avatar.moveDown(100);
        System.out.println("avatar:"+avatar.xCenter +","+avatar.yCenter);
        System.out.println("avatar2:"+avatar2.xCenter +","+avatar2.yCenter);
        avatar.moveDown(100);
        System.out.println("avatar:"+avatar.xCenter +","+avatar.yCenter);
        System.out.println("avatar2:"+avatar2.xCenter +","+avatar2.yCenter);
        avatar2.setLocation(400,200);
        System.out.println("avatar:"+avatar.xCenter +","+avatar.yCenter);
        System.out.println("avatar2:"+avatar2.xCenter +","+avatar2.yCenter);
        System.out.println("avatar3:"+avatar3.xCenter +","+avatar3.yCenter);
        Frame.createFrame();


        /* // Cant use this test code because there is no easy way to re-generate a frame, and refreshing the frame does not reopen the window
        //test code
        boolean c=true;
        int x,y;
        Scanner in = new Scanner(System.in);

        while(c) {
            System.out.println("pos | down | stop ");
            switch (in.nextLine()) {
                case "pos":
                    System.out.println("Enter x coordinate:");
                    x = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter y coordinate:");
                    y = in.nextInt();
                    in.nextLine();
                    avatar.setLocation(x,y);
                    Frame.createFrame();
                    break;
                case "down":
                    System.out.println("Enter amount to move down:");
                    y = in.nextInt();
                    in.nextLine();
                    avatar.moveDown(y);
                    Frame.createFrame();
                    break;
                case "stop":
                    c=false;
                    break;
                default:
                    System.out.println("Not a valid entry");
                    break;
            }
            */
    }
}