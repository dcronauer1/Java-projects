import wheelsFX.users.Frame.Animator;
import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Rectangle;
import java.lang.Math;


/**
 * Tree.java
 * Class to build and handle a seasonally-affected tree
 *
 * @author Dominic Cronauer
 */
public class Tree implements Seasonal, Animator {
    private int curSeason;
    private int DELAY;
    private int callCount;
    // Define tree components
    private Rectangle trunk;
    private Ellipse[] leaves;
    private Ellipse snowpile;
    private Rectangle[] branches;
    private int xCoord,yCoord;


    /**
     * Constructor that builds a tree at 200,300
     * @param delay delay between scene transitions
     */
    public Tree(int delay) {makeTree(200, 300,delay);}

    /**
     * Constructor that builds a tree at x and y coordinate
     * @param xCoord x coordinate to build the tree
     * @param yCoord y coordinate to build the tree
     * @param delay delay between scene transitions
     */
    public Tree(int xCoord, int yCoord,int delay) {makeTree(xCoord, yCoord,delay);}


    /**
     * Method to make the tree at defined x and y coordinates
     * @param x x coordinate
     * @param y y coordinate
     * @param delay delay between scene transitions
     */
    protected void makeTree(int x,int y,int delay) {
        this.curSeason = 0;
        this.callCount = 0;
        this.DELAY = delay;
        this.xCoord=x;
        this.yCoord=y;
        int leavesCount=11;
        // Initialize tree components
        //snow
        snowpile = new Ellipse(Color.GREEN); //start as green
        snowpile.setSize(40, 20);
        snowpile.setLocation(xCoord+10, yCoord+100);
        //make branches
        branches = new Rectangle[leavesCount];
        for (int i = 0; i < leavesCount; i++) {
            branches[i] = new Rectangle(Color.TRANSPARENT);
            branches[i].setSize(4, 20);
            branches[i].setLocation((xCoord-12) + i * 4, (yCoord-20) + Math.abs(i-((int)Math.floor(leavesCount/2d)))*15);
            branches[i].setRotation(20*(i-((int)Math.floor(leavesCount/2d))));
        }
        //trunk
        trunk = new Rectangle(Color.BROWN);
        trunk.setSize(20, 100);
        trunk.setLocation(xCoord, yCoord);
        //Array of 11 leaves
        leaves = new Ellipse[leavesCount];
        for (int i = 0; i < leavesCount; i++) {
            leaves[i] = new Ellipse(Color.GREEN);
            leaves[i].setSize(8, 12);
            //position and rotation math
            leaves[i].setLocation((xCoord-10) + i * 4, (yCoord-10) + Math.abs(i-((int)Math.floor(leavesCount/2d)))*15);
            leaves[i].setRotation(20*(i-((int)Math.floor(leavesCount/2d))));
        }
    }
    /**
     * Overridden implementation from Seasonal.java for spring
     */
    @Override
    public void spring() {
        // Spring behavior
        snowpile.setColor(Color.GREEN);
        for (Ellipse leaf : leaves) {
            leaf.setSize(8, 12);
            leaf.setColor(Color.GREEN);
        }
        for (Rectangle branch : branches) {
            branch.setColor(Color.TRANSPARENT);
        }
    }
    /**
     * Overridden implementation from Seasonal.java for summer
     */
    @Override
    public void summer() {
        snowpile.setColor(Color.DARKGREEN); //not winter
        for (Ellipse leaf : leaves) {
            leaf.setSize(12, 18);
            leaf.setColor(Color.DARKGREEN);
        }
    }
    /**
     * Overridden implementation from Seasonal.java for fall
     */
    @Override
    public void fall() {
        snowpile.setColor(Color.ORANGE); //not winter
        for (Ellipse leaf : leaves) {
            leaf.setColor(Color.ORANGE);
        }
    }

    /**
     * Overridden implementation from Seasonal.java for winter
     */
    @Override
    public void winter() {
        snowpile.setColor(Color.WHITE);
        for (Ellipse leaf : leaves) {
            leaf.setColor(Color.TRANSPARENT);  // fell off
        }
        for (Rectangle branch : branches) {
            branch.setColor(Color.BROWN);
        }

    }

    /**
     * Implemented class from Animator to animate the Tree object through the seasons
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
