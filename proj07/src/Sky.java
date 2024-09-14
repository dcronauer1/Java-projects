import wheelsFX.users.Frame.Animator;
import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Rectangle;

import java.util.Random;

/**
 * Sky.java
 * Class to build and handle seasonally effected scenery
 *
 * @author Dominic Cronauer
 */
public class Sky implements Seasonal, Animator {
    private int curSeason;
    private int DELAY;
    private int callCount;
    // Define Sky components
    private Ellipse[][] clouds;
    private Ellipse sun;
    private int cloudAmount[] ={9,4};//{clouds,"puffs"}
    private Rectangle skybackground;
    private Rectangle ground;

    /**
     * Constructor to make the Sky and scenery
     * @param delay delay between scene transitions
     */
    public Sky(int delay) {
        this.curSeason = 0;
        this.callCount = 0;
        this.DELAY = delay;
        //Initialize components
        //create sky background
        skybackground = new Rectangle(Color.SKYBLUE);
        skybackground.setSize(800,200);
        //create ground
        ground = new Rectangle(Color.LIGHTGREEN);
        ground.setSize(800,600);
        ground.setLocation(0,200);

        //create cloud shapes
        clouds = new Ellipse[cloudAmount[0]][cloudAmount[1]];
        for (int i = 0; i < cloudAmount[0]; i++) {
            for (int j = 0; j < cloudAmount[1]; j++) {
                clouds[i][j] = new Ellipse(Color.TRANSPARENT);
            }
        }
        CloudRandom(Color.DARKGREY); //set initial positions of clouds
        //create sun
        sun = new Ellipse(Color.YELLOW);
        sun.setSize(40, 40);

    }

    /**
     * Method to handle random positioning of clouds
     * @param cloudColor color of the clouds
     */
    private void CloudRandom(Color cloudColor){
        Random randNum = new Random();
        for (int i = 0; i < clouds.length; i++) {
            int randSize = randNum.nextInt(5);
            int randPosX = randNum.nextInt(800);
            int randPosY = randNum.nextInt(100);
            for (int j = 0; j < 4; j++) {
                int randPosXOffset = randNum.nextInt(256);
                int randRotation = randNum.nextInt(30);
                int randWidth = randNum.nextInt(2);
                int randHeight = randNum.nextInt(2);
                clouds[i][j].setColor(cloudColor);
                //make mother cloud
                if (j == 0) {
                    clouds[i][j].setLocation(randPosX + 10, randPosY + 10);
                    clouds[i][j].setSize((randSize + 3) * 4*(randWidth+2), (randSize + 3) * 3*(randHeight+2));
                } else {//make other clouds
                    clouds[i][j].setLocation((int) (randPosX + 10 + ((randPosXOffset - 128)*(10*(randSize + 2))/128)), randPosY + 10);//takes the offset, makes it span -128->128, scales it based on the mother cloud but less
                    clouds[i][j].setSize((randSize + 1) * (randWidth + 2) * 5,(randSize + 1) * (randHeight + 2) * 5);//size
                    clouds[i][j].setRotation(randRotation * j * 12);//rotation
                }
            }
        }
    }
    /**
     * Overridden implementation from Seasonal.java for spring
     */
    @Override
    public void spring() {
        ground.setColor(Color.LIGHTGREEN);
        sun.setSize(40, 40);
        sun.setColor(Color.YELLOW);
        CloudRandom(Color.DARKGREY);//dark grey is lighter than gray?
    }
    /**
     * Overridden implementation from Seasonal.java for summer
     */
    @Override
    public void summer() {
        skybackground.setColor(Color.DEEPSKYBLUE);
        sun.setSize(50, 50);
        sun.setColor(Color.ORANGE);
        CloudRandom(Color.LIGHTGREY);

    }
    /**
     * Overridden implementation from Seasonal.java for fall
     */
    @Override
    public void fall() {
        skybackground.setColor(Color.SKYBLUE);
        sun.setSize(40, 40);
        sun.setColor(Color.ORANGE);
        CloudRandom(Color.DARKGREY); //dark grey is lighter than gray?
    }

    /**
     * Overridden implementation from Seasonal.java for winter
     */
    @Override
    public void winter() {
        ground.setColor(Color.WHITESMOKE);//dark grey is lighter than gray?
        skybackground.setColor(Color.LIGHTSKYBLUE);
        sun.setSize(33, 33);
        sun.setColor(Color.YELLOW);
        CloudRandom(Color.GREY);
    }

    /**
     * Implemented class from Animator to animate the Sky object through the seasons
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
