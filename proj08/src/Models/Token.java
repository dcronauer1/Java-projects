package Models;
import Views.Board;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Rectangle;
import javafx.scene.paint.Color;

/**
 * Class to make and handle tokens
 */
public class Token {
    public int value;
    private Rectangle x1, x2;
    private Ellipse o1,o2;
    int gridSize = Board.gridSize;
    private int size;

    /**
     * constructor to make a token
     * @param value value of the token (nothing, X, O)
     */
    public Token(int value) {
        this.value = value;
        this.x1 = new Rectangle();
        this.x2 = new Rectangle();
        this.x1.setSize(Math.round((float)(gridSize*.25)),gridSize);
        this.x2.setSize(Math.round((float)(gridSize*.25)),gridSize);
        this.x1.setRotation(45);
        this.x2.setRotation(-45);
        this.o1 = new Ellipse();
        this.o2 = new Ellipse();
        this.o1.setSize(gridSize/2,gridSize/2);
        this.o2.setSize(gridSize/2-Math.round((float)(gridSize*.15)),gridSize/2-Math.round((float)(gridSize*.15)));
        this.size=gridSize;

        setState(value);
    }

    /**
     * Method to set the location of the token
     * @param x x coordinate
     * @param y y coordinate
     */
    public void setLocation(int x, int y) {
        this.x1.setLocation(x+(Math.round((float)(size*.37))), y);//cant get the math right here, so just brute forced it
        this.x2.setLocation(x+(Math.round((float)(size*.37))), y);
        this.o1.setLocation(x+(int)(this.size /2), y+(int)(this.size/2));
        this.o2.setLocation(x+(int)(this.size /2), y+(int)(this.size/2));

    }

    /**
     * Method to set the size of the token
     * @param x size x
     * @param y size y
     */
    public void setSize(int x, int y) {
        this.x1.setSize(Math.round((float)(x*.25)), y);
        this.x2.setSize(Math.round((float)(x*.25)), y);
        this.o1.setSize(x/2, y/2);
        this.o2.setSize(x/2-Math.round((float)(x*.15)), y/2-Math.round((float)(y*.15)));
        this.size =x;
    }

    /**
     * Method to handle changing the state of the token.
     * @param state state of the token. State 0 is nothing, odds are X and evens are O
     */
    public void setState(int state) {
        this.value = state;
        if(state%2==1){
            this.o1.setColor(Color.TRANSPARENT);
            this.o2.setColor(Color.TRANSPARENT);
        }
        else{//if case 0 is called this will execute
            this.x1.setColor(Color.TRANSPARENT);
            this.x2.setColor(Color.TRANSPARENT);
        }
        switch (state) {
            case 0: //nothing
                this.o1.setColor(Color.TRANSPARENT);
                this.o2.setColor(Color.TRANSPARENT);
                break;
            case 1: //x
                this.x1.setColor(Color.BLUE);
                this.x2.setColor(Color.BLUE);
                break;
            case 2: //O
                this.o1.setColor(Color.RED);
                this.o2.setColor(Color.WHITE);
                break;
            case 3: //player 3
                this.x1.setColor(Color.GREEN);
                this.x2.setColor(Color.GREEN);
                break;
            case 4: //player 4
                this.o1.setColor(Color.ORANGE);
                this.o2.setColor(Color.WHITE);
                break;
            case 5: //player 5
                this.x1.setColor(Color.YELLOW);
                this.x2.setColor(Color.YELLOW);
                break;
            case 6: //player 6
                this.o1.setColor(Color.PURPLE);
                this.o2.setColor(Color.WHITE);
                break;
            default:
                System.out.println("Token.stateChange error"); //should never see this
        }
    }

    /**
     * Method to get the value of the token
     * @return value of the token
     */
    public int getValue() {
        return this.value;
    }
}
