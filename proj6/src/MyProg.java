import wheelsFX.users.Frame.Frame;
/**
 * MyProg.java
 * A class to handle program execution
 *
 * @author Dominic Cronauer
 */
public class MyProg {
    /**
     * function main begins with program execution
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Car baseCar = new Car(200, 200);
        RocketCar rocketCar = new RocketCar(400, 500);
        WinterCar winterCar = new WinterCar(600, 200);
        Frame.createFrame();
    }
}
