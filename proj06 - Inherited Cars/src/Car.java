import javafx.scene.paint.Color;
import wheelsFX.users.Frame.Frame;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Rectangle;


/**
 * Car.java
 * A class to construct the base car, and move it around
 *
 * @author Dominic Cronauer
 */
public class Car {
    protected int xCenter;
    protected int yCenter;
    private Rectangle body;
    private Ellipse leftFrontWheel;
    private Ellipse rightFrontWheel;
    private Ellipse leftRearWheel;
    private Ellipse rightRearWheel;
    private Rectangle roof;
    private final Color carColor = Color.BLUE, wheelColor = Color.BLACK, roofColor = Color.GRAY;

    /**
     * Constructor that builds car at 0,0.
     */
    public Car() {
        makeCar(0, 0);
        this.xCenter = this.yCenter = 0;
    }

    /**
     * Constructor that builds car at x and y coordinates from passed in integers.
     * @param x x coordinate to build car at
     * @param y y coordinate to build car at
     */
    public Car(int x, int y) {
        makeCar(x, y);
        this.xCenter = x;
        this.yCenter = y;
    }

    /**
     * Method to make the car at defined x and y coordinates
     * @param x x coordinate to make car at
     * @param y y coordinate to make car at
     */
    protected void makeCar(int x, int y) {
        //Create the rear wheels (relative to the viewer)
        leftRearWheel = new Ellipse(wheelColor);
        leftRearWheel.setSize(50, 50);
        leftRearWheel.setLocation(x - 60, y - 20);

        rightRearWheel = new Ellipse(wheelColor);
        rightRearWheel.setSize(50, 50);
        rightRearWheel.setLocation(x + 50, y - 20);

        // Create the car body
        body = new Rectangle(carColor);
        body.setSize(200, 100);
        body.setLocation(x - 100, y - 50);

        // Create the front wheels
        leftFrontWheel = new Ellipse(wheelColor);
        leftFrontWheel.setSize(50, 50);
        leftFrontWheel.setLocation(x - 70, y + 25);

        rightFrontWheel = new Ellipse(wheelColor);
        rightFrontWheel.setSize(50, 50);
        rightFrontWheel.setLocation(x + 40, y + 25);

        // Create the car roof last (so it is on top)
        roof = new Rectangle(roofColor);
        roof.setSize(120, 50);
        roof.setLocation(x - 60, y - 90);

    }
    /**
     * Set the location of the Car to the specified x and y location
     * @param x x location of car
     * @param y y location of car
     */
    public void setLocation(int x, int y) {
        leftRearWheel.setLocation(x - 60, y - 20);
        rightRearWheel.setLocation(x + 50, y - 20);
        body.setLocation(x - 100, y - 50);
        leftFrontWheel.setLocation(x - 70, y + 25);
        rightFrontWheel.setLocation(x + 40, y + 25);
        roof.setLocation(x - 60, y - 90);
        this.xCenter = x;
        this.yCenter = y;
    }
    /**
     * Move the Car up or down dy units
     * @param dy # of units to move car
     */
    public void moveDown(int dy) {
        setLocation(this.xCenter, this.yCenter + dy);
    }
}
