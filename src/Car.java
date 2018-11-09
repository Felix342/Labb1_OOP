import org.omg.PortableInterceptor.DISCARDING;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An abstract class that implements the interface "Movable". Describes the basic functionality of a standard car.
 */
public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction direction = Direction.FORWARD;
    public static ArrayList<Direction> directions = initDirections();

    private double x = 250;
    private double y = 250;

    private static ArrayList<Direction> initDirections(){
        ArrayList<Direction> temp = new ArrayList();
        temp.add(Direction.RIGHT);
        temp.add(Direction.BACKWARD);
        temp.add(Direction.LEFT);
        temp.add(Direction.FORWARD);
        return temp;
    }


    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();

    }

    /**
     * @return the x-position of the car.
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y-position of the car.
     */
    public double getY() {
        return y;
    }

    private enum Direction {
        LEFT,
        FORWARD,
        RIGHT,
        BACKWARD
    }

    /**
     * Adds currentSpeed to x and y according to direction.
     */
    public void move() {
        switch (direction) {
            case LEFT:
                x -= getCurrentSpeed();
                break;
            case RIGHT:
                x += getCurrentSpeed();
                break;
            case FORWARD:
                y -= getCurrentSpeed();
                break;
            case BACKWARD:
                y += getCurrentSpeed();
                break;
            default:
                break;
        }
    }

    /**
     * Turns the car left (relative to the car) by changing the direction.
     */
    public void turnLeft() {
        direction = directions.get((directions.indexOf(direction) - 1) % directions.size());
    }

    /**
     * Turns the car right (relative to the car) by changing the direction.
     */
    public void turnRight() {
        direction = directions.get((directions.indexOf(direction) + 1) % directions.size());
    }

    /**
     * @return number of doors on the car.
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * @return the enginePower of the car.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * @return currentSpeed of the car;
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return the color of the car.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Changes the color of the car to the param.
     *
     * @param clr
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Sets the currentSpeed of the car to 0.1
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Sets the currentSpeed of the car to 0
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     *
     * @return the speedFactor of the car.
     */
    public abstract double getSpeedFactor();

    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed < 0) {
            this.currentSpeed = 0;
        } else if (currentSpeed > enginePower) {
            this.currentSpeed = enginePower;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }

    /**
     * Increases the currentSpeed of the car with speedFactor and amount
     *
     * @param amount of increase.
     */
    public void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + getSpeedFactor() * amount);
    }

    /**
     * Decreases the currentSpeed of the car with speedFactor and amount
     *
     * @param amount of decrease.
     */
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - getSpeedFactor() * amount);
    }

    /**
     * Accelerates by increasing speed by param.
     *
     * @param amount
     */
    public void gas(double amount) {
        if (amount > 1 || amount < 0) {
            return;
        }
        incrementSpeed(amount);
    }

    /**
     * De-accelerates by decreasing speed by param.
     *
     * @param amount
     */
    public void brake(double amount) {
        if (amount > 1 || amount < 0) {
            return;
        }
        decrementSpeed(amount);
    }

}
