import java.awt.*;

/**
 * A type of car that has a bed.
 */
public abstract class Truck extends Car implements Tiltable{

    private Bed bed;

    public Truck(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName, nrDoors);


    }

    /**
     *
     * @return speedfactor of the truck.
     */
    @Override
    public double getSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Moves the truck.
     */
    @Override
    public void move() {
        if(bed.getDegrees() == 0) {
            super.move();
        }
    }

    /**
     * sets the instance of the bed.
     * @param bed sets local instance of bed to its value.
     */
    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Bed getBed(){
        return bed;
    }

    /**
     * @return the current degree of the tilt of the load
     */
    @Override
    public double getDegrees() {
        return bed.getDegrees();
    }



}
