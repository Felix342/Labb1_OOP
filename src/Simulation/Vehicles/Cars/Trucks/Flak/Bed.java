package Simulation.Vehicles.Cars.Trucks.Flak;

import Simulation.Interfaces.Tiltable;

/**
 * A platform which can raise and lower its load. (Flak)
 */
public class Bed {

    private Tiltable owner;
    private double degrees = 0;

    public Bed(Tiltable owner) {
        this.owner = owner;
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
    public void raiseLoad(int amount) {
        if(owner.getCurrentSpeed() == 0) {
            System.out.println("LoadRaised");
            if (degrees + amount >= 70)
                degrees = 70;
            else
                degrees += amount;
        }
    }

    /**
     * Lower the load
     */
    public void lowerLoad(int amount) {
        if (owner.getCurrentSpeed() == 0) {
            System.out.println("LoadLowered");
            if (degrees - amount <= 0)
                degrees = 0;
            else
                degrees -= amount;

        }
    }
}
