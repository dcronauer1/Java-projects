import wheelsFX.users.Frame.Frame;
import wheelsFX.users.Frame.AnimationTimer;
/**
 * SeasonsOfWheels.java
 * A class to handle program execution
 *
 * @author Dominic Cronauer
 */
public class SeasonsOfWheels {
    /**
     * function main begins with program execution
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        //make sure sky is first for layering reasons
        final int delay=60;
        Sky sky = new Sky(delay);
        AnimationTimer timer1 = new AnimationTimer(sky);
        Tree tree = new Tree(200,300,delay);
        Tree tree2 = new Tree(100,250,delay);
        Tree tree3 = new Tree(300,400,delay);
        Tree tree4 = new Tree(540,350,delay);
        Tree tree5 = new Tree(630,270,delay);
        Tree tree6 = new Tree(700,380,delay);
        AnimationTimer timer2 = new AnimationTimer(tree);
        AnimationTimer timer3 = new AnimationTimer(tree2);
        AnimationTimer timer4 = new AnimationTimer(tree3);
        AnimationTimer timer5 = new AnimationTimer(tree4);
        AnimationTimer timer6 = new AnimationTimer(tree5);
        AnimationTimer timer7 = new AnimationTimer(tree6);
        House house = new House(400,400,delay);
        AnimationTimer timer8 = new AnimationTimer(house);

        Frame.createFrame();
    }
}
