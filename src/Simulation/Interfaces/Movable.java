package Simulation.Interfaces;

/**
 * An interface for all movable objects. Has the ability to move, and turn left or right.
 */
public interface Movable {
    /**
     * Moves the car forward (relative to car).
     */
    void move();

    /**
     * Turns the car left (relative to car)
     */
    void turnLeft();

    /**
     * Turns the car right (relative to car)
     */
    void turnRight();

    double getX();

    double getY();

    void setX(double x);

    void setY(double y);


}