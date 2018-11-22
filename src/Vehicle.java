import java.awt.*;
import java.util.ArrayList;

public abstract class Vehicle implements Movable{


    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vehicle.Direction direction = Car.Direction.FORWARD;
    public static ArrayList<Vehicle.Direction> directions = initDirections();

    private double x = 250;
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

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public String getModelName() {
        return modelName;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
