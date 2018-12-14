package Simulation.Model;

public interface Storeable{


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


    void setLoaded(boolean b);

    boolean isLoaded();

    double getX();

    double getY();

    void setX(double x);

    void setY(double y);

}
