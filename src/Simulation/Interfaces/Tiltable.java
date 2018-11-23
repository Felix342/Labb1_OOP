package Simulation.Interfaces;

/**
 * Describes an object that can tilt a load.
 */
public interface Tiltable {

    /**
     * Raises the load.
     */
    void raiseLoad();

    /**
     * Lowers the load.
     */
    void lowerLoad();

    /**
     *
     * @return the current speed of the object.
     */
    double getCurrentSpeed();

    /**
     *
     * @return the current degree of the tilt of the load
     */
    double getDegrees();


}
