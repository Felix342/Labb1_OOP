import java.awt.*;
/**
 * A class representing a Scania truck
 */
public class Scania extends Truck {


    private double speedFactor = 1.5;
    private Bed bed = new Bed();



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
        if(getCurrentSpeed() == 0) {
            bed.lowerLoad(1);
        }
    }

    @Override
    public void move() {
        if(bed.getDegrees() == 0){
            super.move();
        }
    }

    /**
     * @return the speed factor
     */
    @Override
    public double getSpeedFactor() {
        return speedFactor;
    }
}
