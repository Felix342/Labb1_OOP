package Simulation.Model.Vehicles.Trucks.Flak;

/**
 * A platform which can raise and lower its load. (Flak)
 */
public class Bed extends AbstractBed{

    public Bed(double x, double y) {
        super(x, y);
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
