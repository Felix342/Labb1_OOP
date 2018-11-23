import java.awt.*;

/**
 * A truck of the model Mang90.
 */
public class MANG90 extends Truck implements Loadable {

    private final Car[] cars = new Car[10];
    private Trailer trailer = new Trailer(this);


    public MANG90(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName, nrDoors);
        setBed(trailer);
    }

    /**
     * @param c is the car to be loaded onto the load
     */
    @Override
    public void load(Car c) {
        trailer.load(c);
    }

    /**
     * unloads the last car from the load
     *
     * @return the unloaded car
     */
    @Override
    public Car unLoad() {
        return trailer.unLoad(trailer.getLastCar());
    }

    /**
     * Turns the MANG90 and all loaded cars to the left
     */
    @Override
    public void turnLeft() {
        super.turnLeft();
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null)
                cars[i].turnLeft();
        }
    }

    /**
     * Turns the MANG90 and all loaded cars to the right
     */
    @Override
    public void turnRight() {
        super.turnRight();
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null)
                cars[i].turnRight();
        }
    }

    /**
     * lowers the load
     */
    public void lowerLoad() {
        trailer.lowerLoad(70);
    }



    /**
     * raise the load
     */
    public void raiseLoad() {
        trailer.raiseLoad(70);
    }

    /**
     * moves the Truck and the loaded cars
     */
    @Override
    public void move() {

        super.move();
        trailer.moveAllChildren();

    }

    /**
     *
     * @return the trailer of the MANG90
     */
    public Trailer getTrailer() {
        return trailer;
    }

}
