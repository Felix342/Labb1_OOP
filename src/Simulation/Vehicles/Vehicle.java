package Simulation.Vehicles;

import Simulation.Interfaces.Movable;
import Simulation.Vehicles.Cars.Car;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * A vehicle that has a position.
 */
public abstract class Vehicle implements Movable {

    private boolean isLoaded = false;
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vehicle.Direction direction = Direction.RIGHT;
    public static ArrayList<Vehicle.Direction> directions = initDirections();

    private double x = 0;
    private double y = 250;


    public Vehicle(double enginePower, double currentSpeed, Color color, String modelName) {
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

    private static ArrayList<Direction> initDirections() {
        ArrayList<Direction> temp = new ArrayList();
        temp.add(Direction.RIGHT);
        temp.add(Direction.BACKWARD);
        temp.add(Direction.LEFT);
        temp.add(Direction.FORWARD);
        return temp;
    }

    /**
     * Direction enumeration
     */
    public enum Direction {
        LEFT,
        FORWARD,
        RIGHT,
        BACKWARD
    }

    /**
     * Adds currentSpeed to x and y according to direction.
     */
    public void move() {
        if(isLoaded())
            return;

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
     *
     * @return if the car is loaded
     */
    public boolean isLoaded() {
        return isLoaded;
    }

    /**
     * sets the status of the vehichle
     * @param loaded
     */
    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    /**
     * Turns the car left (relative to the car) by changing the direction.
     */
    //+3 för att undervika minus besvär
    public void turnLeft() {
        direction = directions.get((directions.indexOf(direction) + 3) % directions.size());
    }

    /**
     * Turns the car right (relative to the car) by changing the direction.
     */
    public void turnRight() {
        direction = directions.get((directions.indexOf(direction) + 1) % directions.size());
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
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
     * @return the speedFactor of the car.
     */
    public abstract double getSpeedFactor();

    /**
     *
     * @param currentSpeed the value to set the Vehicles current speed to
     */
    private void setCurrentSpeed(double currentSpeed) {
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
     * @param amount of increase.
     */
    private void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + getSpeedFactor() * amount);
    }

    /**
     * Decreases the currentSpeed of the car with speedFactor and amount
     * @param amount of decrease.
     */
    private void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - getSpeedFactor() * amount);
    }

    /**
     * Accelerates by increasing speed by param.
     * @param amount
     */
    //currentSpeed = 0 är motor avstängd.
    public void gas(double amount) {
        if (amount > 1 || amount < 0 || 0 == currentSpeed) {
            return;
        }
        incrementSpeed(amount);
    }

    /**
     * De-accelerates by decreasing speed by param.
     * @param amount
     */
    public void brake(double amount) {
        if (amount > 1 || amount < 0) {
            return;
        }
        decrementSpeed(amount);
    }

    /**
     * sets the engine power of the vehicle
     * @param enginePower sets the local instance of enginePower to its value
     */
    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * get the model name of the vehicle
     * @return the model name of the vehicle
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * sets the direction of the vehicle.
     * @param direction sets the local instance of direction to its value
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * sets the x-position of the vehicle.
     * @param x sets the local instance of x to its value.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * sets the y-position of the vehicle.
     * @param y sets the local instance of x to its value.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * get the x-position of the vehicle.
     * @return the x-position of the vehicle.
     */
    public double getX() {
        return x;
    }

    /**
     * get the y-position of the vehicle.
     * @return the y-position of the vehicle.
     */
    public double getY() {
        return y;
    }

}
