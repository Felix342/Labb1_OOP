import java.awt.*;

public class CarFerry implements Vehicle{
    private Trailer trailer = new Trailer();




    /**
     * turns the ferry left
     */
    public void turnLeft(){
        trailer.turnLeft();
    }

    /**
     * turns the ferry right
     */
    public void turnRight(){
        trailer.turnRight();
    }

    /**
     * loads a car to the ferry
     * @param c the car to be loaded
     */
    public void loadFerry(Car c){
    }

    /**
     *
     * @return the unloaded car
     */
    public Car unloadFerry(){
        return trailer.removeCar(trailer.getFirstCar());
    }

    /**
     * moves the ferry
     */
    @Override
    public void move() {
        trailer.move();
    }

    /**
     *
     * @return the enginePower
     */
    @Override
    public double getEnginePower() {
        return trailer.getEnginePower();
    }

    /**
     *
     * @return the currentSpeed
     */
    @Override
    public double getCurrentSpeed() {
        return trailer.getCurrentSpeed();
    }

    /**
     * starts the engine
     */
    @Override
    public void startEngine() {
        trailer.startEngine();
    }

    /**
     * stops the engine
     */
    @Override
    public void stopEngine() {
        trailer.stopEngine();
    }

    /**
     * accelerates the ferry
     * @param d amount of gasing power
     */
    @Override
    public void gas(double d) {
        trailer.gas(d);
    }

    /**
     * deaccelerates the ferry
     * @param d amount of braking power
     */
    @Override
    public void brake(double d) {
        trailer.brake(d);
    }
}
