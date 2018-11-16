import java.awt.*;

public class CarFerry implements Vehicle{
    private MANG90 mang90 = new MANG90(2, 100, Color.blue);

    /**
     * turns the ferry left
     */
    public void turnLeft(){
        mang90.turnLeft();
    }

    /**
     * turns the ferry right
     */
    public void turnRight(){
        mang90.turnRight();
    }

    /**
     * loads a car to the ferry
     * @param c the car to be loaded
     */
    public void loadFerry(Car c){
        mang90.addCar(c);
    }

    /**
     *
     * @return the unloaded car
     */
    public Car unloadFerry(){
        return mang90.removeCar(mang90.getFirstCar());
    }

    /**
     * moves the ferry
     */
    @Override
    public void move() {
        mang90.move();
    }

    /**
     *
     * @return the enginePower
     */
    @Override
    public double getEnginePower() {
        return mang90.getEnginePower();
    }

    /**
     *
     * @return the currentSpeed
     */
    @Override
    public double getCurrentSpeed() {
        return mang90.getCurrentSpeed();
    }

    /**
     * starts the engine
     */
    @Override
    public void startEngine() {
        mang90.startEngine();
    }

    /**
     * stops the engine
     */
    @Override
    public void stopEngine() {
        mang90.stopEngine();
    }

    /**
     * accelerates the ferry
     * @param d amount of gasing power
     */
    @Override
    public void gas(double d) {
        mang90.gas(d);
    }

    /**
     * deaccelerates the ferry
     * @param d amount of braking power
     */
    @Override
    public void brake(double d) {
        mang90.brake(d);
    }
}
