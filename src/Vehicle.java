public interface Vehicle {
    /**
     * Moves the vehicle
     */
    void move();

    /**
     *
     * @return the enginePower of the vehicle
     */
    double getEnginePower();

    /**
     *
     * @return the currentSpeed of the vehicle
     */
    double getCurrentSpeed();

    /**
     * starts the vehicles engine
     */
    void startEngine();

    /**
     * stops the Engine
     */
    void stopEngine();

    /**
     * accelerate the vehicle
     * @param d amount of gasing power
     */
    void gas(double d);

    /**
     * deaccelerated the vehicle
     * @param d amount of braking power
     */
    void brake(double d);


}
