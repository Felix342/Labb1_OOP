package Simulation.Vehicles.Trucks.Flak;

/**
 * A platform which can raise and lower its load. (Flak)
 */
public class Bed extends AbstractBed{
    private double degrees = 0;

    public Bed(double x, double y) {
        super(x, y);


    }

    /**
     * @return degrees of the load
     */
    public double getDegrees() {
        return degrees;
    }

    /**
     * Raise the load
     */
    public void raiseLoad() {
        super.raiseLoad(10);
    }

    /**
     * Lower the load
     */
    public void lowerLoad() {
        super.lowerLoad(10);
    }
}
