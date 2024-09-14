import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Rectangle;
/**
 * RocketCar.java
 * A class built off of the Car class
 *
 * @author Dominic Cronauer
 */
public class RocketCar extends Car {
    private Rectangle rocketEngine;

    /**
     * Constructor that builds rocket car at x,y
     * @param x position
     * @param y position
     */
    public RocketCar(int x, int y) {
        super(x, y);
        addRocketEngine(x, y);
    }
    /**
     * Constructor that builds a rocket car at 0,0.
     */
    public RocketCar() {
        super(0, 0);
        addRocketEngine(0,0);

    }

    /**
     * add a rocket engine to the base car
     * @param x position
     * @param y position
     */
    private void addRocketEngine(int x, int y) {
        rocketEngine = new Rectangle(Color.RED);
        rocketEngine.setSize(50, 120);
        rocketEngine.setLocation(x - 125, y - 70);
        rocketEngine.setRotation(90);
    }
    /**
     * Override the setLocation function to include the added parts
     * @param x x location of car
     * @param y y location of car
     */
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        rocketEngine.setLocation(x - 125, y - 70);
    }
    /**
     * Override the moveDown function to include the added parts
     * @param dy height to move
     */
    @Override
    public void moveDown(int dy) {
        super.moveDown(dy);
        rocketEngine.setLocation(this.xCenter - 125, this.yCenter - 70);
    }
}
