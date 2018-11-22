import java.awt.*;

public class CarFerry extends Vehicle implements Loadable{
    private Trailer trailer = new Trailer(this);


    public CarFerry(double enginePower, double currentSpeed, Color color, String modelName) {
        super(enginePower, currentSpeed, color, modelName);
    }

    /**
     * loads a car to the ferry
     * @param c the car to be loaded
     */
    @Override
    public void load(Car c) {
        trailer.load(c);
    }

    /**
     * moves the CarFerry and the loaded cars
     */
    @Override
    public void move() {
        if(trailer.getDegrees() == 0) {
            super.move();
            trailer.moveAllChildren();
        }
    }

    /**
     * lowers the load
     */
    public void lowerLoad() {
        if (getCurrentSpeed() == 0) {
            trailer.lowerLoad(70);
        }
    }

    /**
     * rais the load
     */
    public void raiseLoad() {
        if (getCurrentSpeed() == 0) {
            trailer.raiseLoad(70);
        }
    }



    /**
     *
     * @return the unloaded car
     */
    @Override
    public Car unLoad() {
        return trailer.unLoad(trailer.getFirstCar());
    }



    @Override
    public double getSpeedFactor() {
        return 0;
    }
}
