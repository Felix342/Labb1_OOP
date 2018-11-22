import java.awt.*;

public abstract class Truck extends Car{

    private Bed bed;

    public Truck(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName, nrDoors);
    }

    @Override
    public double getSpeedFactor() {
        return 0;
    }

    @Override
    public void move() {
        if(bed.getDegrees() == 0) {
            super.move();
        }
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
