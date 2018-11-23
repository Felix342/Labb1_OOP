import java.awt.*;

/**
 * A Ferry which can hold cars.
 */
public class CarFerry extends Vehicle implements Loadable {
    private Trailer trailer = new Trailer(this);


    public CarFerry(double enginePower, double currentSpeed, Color color, String modelName) {
        super(enginePower, currentSpeed, color, modelName);
    }

    /**
     * loads a car to the ferry
     *
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
        if (trailer.getDegrees() == 0) {
            super.move();
            trailer.moveAllChildren();
        }
    }

    /**
     * @return the current degree of the tilt of the load
     */
    @Override
    public double getDegrees() {
        return trailer.getDegrees();
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
     * @return the unloaded car
     */
    @Override
    public Car unLoad() {
        return trailer.unLoad(trailer.getFirstCar());
    }


    /**
     * @return the speedfactor of the carferry.
     */
    @Override
    public double getSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     *
     * @return the trailer of the CarFerry
     */
    public Trailer getTrailer() {
        return trailer;
    }
}
