import java.awt.*;
/**
 * A class representing a Scania truck
 */
public class Scania extends Car implements Truck{

    private double degrees = 0;
    private double speedFactor = 1.5;


    public Scania(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    /**
     * @return degrees of the load
     */
    public double getDegrees() {
        return degrees;
    }

    /**
     * @return raise the load
     */
    public void raiseLoad() {
        if(getCurrentSpeed() == 0) {
            degrees++;
            if (degrees >= 70) {
                degrees = 70;
            }
        }
    }

    /**
     * @return lower the load
     */
    public void lowerLoad() {
        if(getCurrentSpeed() == 0) {
            degrees--;
            if (degrees <= 0) {
                degrees = 0;
            }
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
