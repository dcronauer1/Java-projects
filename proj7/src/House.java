import wheelsFX.users.Frame.Animator;
import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Rectangle;
import wheelsFX.users.Shapes.Triangle;

import java.lang.Math;

/**
 * House.java
 * Class to build and handle a seasonally-affected house
 *
 * @author Dominic Cronauer
 */
public class House implements Seasonal, Animator {
    private int curSeason;
    private int DELAY;
    private int callCount;
    // Define house components
    private Rectangle house;
    private Triangle roof;
    private Rectangle[] windows;
    private Rectangle door;
    private Ellipse base;
    private int xCoord,yCoord;


    /**
     * Constructor that builds a house at 200,300
     * @param delay delay between scene transitions
     */
    public House(int delay) {makeHouse(400, 400,delay);}

    /**
     * Constructor that builds a house at x and y coordinate
     * @param xCoord x coordinate to build the house
     * @param yCoord y coordinate to build the house
     * @param delay delay between scene transitions
     */
    public House(int xCoord, int yCoord,int delay) {makeHouse(xCoord, yCoord,delay);}


    /**
     * Method to make the House at defined x and y coordinates
     * @param x x coordinate
     * @param y y coordinate
     * @param delay delay between scene transitions
     */
    protected void makeHouse(int x,int y,int delay) {
        this.curSeason = 0;
        this.callCount = 0;
        this.DELAY = delay;
        this.xCoord=x;
        this.yCoord=y;
        int houseSize = 65;
        //Initialize house components
        //base
        base = new Ellipse(Color.GREEN);
        base.setSize((int)(0.9*houseSize), (houseSize/2));
        base.setLocation((int) (houseSize / 2) + xCoord, yCoord+(int)(0.9*houseSize));
        //house
        house = new Rectangle(Color.GRAY);
        house.setSize(houseSize, houseSize);
        house.setLocation(xCoord, yCoord);
        //roof
        roof = new Triangle(Color.RED);
        roof.setSize((int)(0.36*houseSize),(int)(0.2*houseSize));
        roof.setLocation(xCoord+(int)(0.46*houseSize), yCoord-(int)(0.24*houseSize));
        //door
        door = new Rectangle(Color.BROWN);
        door.setSize((int)(0.4*houseSize),(int)(0.5*houseSize));
        door.setLocation(xCoord+(int)(0.3*houseSize), yCoord+(int)(0.5*houseSize));
        //Array of 2 windows
        windows = new Rectangle[2];
        for (int i = 0; i < windows.length; i++) {
            windows[i] = new Rectangle(Color.LIGHTGREY);
            windows[i].setSize((int)(0.26*houseSize), (int)(0.26*houseSize));
            //position math
            windows[i].setLocation((xCoord+(int)(0.13*houseSize)) + i*((int)(houseSize-(.52*houseSize))), yCoord+(int)(0.22*houseSize));
        }
    }

    /**
     * Overridden implementation from Seasonal.java for spring
     */
    @Override
    public void spring() {
        base.setColor(Color.GREEN);
        roof.setColor(Color.RED);
        house.setColor(Color.GRAY);
        door.setColor(Color.BROWN);
        for (Rectangle window : windows) {
            window.setColor(Color.LIGHTGREY);
        }

    }
    /**
     * Overridden implementation from Seasonal.java for summer
     */
    @Override
    public void summer() {
        base.setColor(Color.DARKGREEN);

    }
    /**
     * Overridden implementation from Seasonal.java for fall
     */
    @Override
    public void fall() {
        base.setColor(Color.ORANGE);
        roof.setColor(Color.ORANGERED);

    }

    /**
     * Overridden implementation from Seasonal.java for winter
     */
    @Override
    public void winter() {
        base.setColor(Color.WHITE);
        roof.setColor(Color.LIGHTGREY);
        house.setColor(Color.DARKGRAY); //why is dark gray brighter than gray??
        door.setColor(Color.ROSYBROWN);
        for (Rectangle window : windows) {
            window.setColor(Color.WHITE);
        }
    }

    /**
     * Implemented class from Animator to animate the House object through the seasons
     */
    public void animate(){
        this.callCount++;
        if(this.callCount%this.DELAY == 0){
            this.curSeason++;
            if(this.curSeason%4 == 1){
                spring();
            }
            else if(this.curSeason%4 == 2){
                summer();
            }
            else if(this.curSeason%4 == 3){
                fall();
            }
            else if(this.curSeason%4 == 0){
                winter();
            }
        }
    }
}
