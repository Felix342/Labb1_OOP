import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An abstract class that implements the interface "Movable". Describes the basic functionality of a standard car.
 */
public abstract class Car extends Vehicle{

    private int nrDoors; // Number of doors on the car



    public Car(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName);
        this.nrDoors = nrDoors;
    }

    /**
     *
     * @return the number of doors on the car.
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Sets the number of doors on the car.
     * @param nrDoors
     */
    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }
}
