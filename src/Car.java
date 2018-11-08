import java.awt.*;

/**
 * An abstract class that implements the interface "Movable". Describes the basic functionality of a standard car.
 */
public abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    //private Direction direction = Direction.FORWARD;
    private double dx = 0;
    private double dy = 0;
    private double x = 250;
    private double y = 250;

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /*private enum Direction {
        LEFT,
        RIGHT,
        FORWARD,
        BACKWARD
    }*/

    /**
     * Adds direction multiplied with currentSpeed to x and y.
     */
    public void move(){
        x += dx * currentSpeed;
        y += dy * currentSpeed;

    }

    /**
     * Sets dx to -1 to simulate x-axis movement.
     */
    public void turnLeft(){
        dx = -1;
        dy = 0;
    }

    /**
     * Sets dx to 1 to simulate x-axis movement.
     */
    public void turnRight(){
        dx = 1;
        dy = 0;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets currentSpeed to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets currentSpeed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double getSpeedFactor();

    /**
     * Increases currentSpeed with speedFactor and amount
     * @param amount of increase.
     */
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + getSpeedFactor() * amount;
    }

    /**
     * Decreases currentSpeed with speedFactor and amount
     * @param amount of decrease.
     */
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - getSpeedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if(amount > 1 || amount <0) {
            return;
        }
        if(currentSpeed > enginePower || currentSpeed < 0){
            return;
        }
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if(amount > 1 || amount <0) {
            return;
        }
        if(currentSpeed > enginePower || currentSpeed < 0){
            return;
        }
        decrementSpeed(amount);
    }

}
