import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Rectangle;
/**
 * WinterCar.java
 * A class built off of the Car class
 *
 * @author Dominic Cronauer
 */
public class WinterCar extends Car {
    private Rectangle leftTread;
    private Rectangle rightTread;
    /**
     * Constructor that builds winter car at x,y
     * @param x position
     * @param y position
     */
    public WinterCar(int x, int y) {
        super(x, y);
        addSnowTreads(x, y);
    }
    /**
     * Constructor that builds a Winter car at 0,0.
     */
    public WinterCar() {
        super(0, 0);
        addSnowTreads(0,0);
    }
    /**
     * add snow treads to the base car
     * @param x position
     * @param y position
     */
    private void addSnowTreads(int x, int y) {
        leftTread = new Rectangle(Color.DARKGRAY);
        leftTread.setSize(100, 50);
        leftTread.setLocation(x - 120, y);

        rightTread = new Rectangle(Color.DARKGRAY);
        rightTread.setSize(100, 50);
        rightTread.setLocation(x-10, y);
    }

    /**
     * Override the setLocation function to include the added parts
     * @param x x location of car
     * @param y y location of car
     */
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        leftTread.setLocation(x - 120, y);
        rightTread.setLocation(x - 10, y);
    }
    /**
     * Override the moveDown function to include the added parts
     * @param dy height to move
     */
    @Override
    public void moveDown(int dy) {
        super.moveDown(dy);
        leftTread.setLocation(this.xCenter - 120, this.yCenter);
        rightTread.setLocation(this.xCenter - 10, this.yCenter);
    }
}
