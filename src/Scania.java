import java.awt.*;

/**
 * A class representing a Scania truck
 */
public class Scania extends Truck {


    private Bed bed = new Bed(this);


    public Scania(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName, nrDoors);
        setBed(bed);
    }

    /**
     * @return raise the load
     */
    public void raiseLoad() {

        bed.raiseLoad(1);

    }

    /**
     * @return lower the load
     */
    public void lowerLoad() {
        bed.lowerLoad(1);
    }

    /**
     * Moves the scania.
     */
    @Override
    public void move() {
        super.move();
    }


    /**
     *
     * @return the bed of the Scania
     */
    public Bed getBed() {
        return bed;
    }

}
