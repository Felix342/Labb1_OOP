import java.awt.*;

public class MANG90 extends Car implements Loadable {
    private double degrees = 0;
    private final Car[] cars = new Car[10];

    public MANG90(int nrDoors, double enginePower, Color color) {
        super(nrDoors, enginePower, color, "MAN G90");
    }

    public Car[] getCars() {
        return cars;
    }

    @Override
    public void turnLeft() {
        super.turnLeft();
        for (int i = 0; i < cars.length; i++) {
            cars[i].turnLeft();
        }
    }

    @Override
    public void turnRight() {
        super.turnRight();
        for (int i = 0; i < cars.length; i++) {
            cars[i].turnRight();
        }
    }

    /**
     *
     * @return the speed factor
     */
    @Override
    public double getSpeedFactor() {
        return 0.9;
    }

    /**
     * lowers the load
     */
    @Override
    public void lowerLoad() {
        if (getCurrentSpeed() == 0) {
            degrees = 0;
        }
    }

    /**
     * rais the load
     */
    @Override
    public void raiseLoad() {
        if (getCurrentSpeed() == 0) {
            degrees = 70;
        }
    }

    /**
     * moves the Truck and the loaded cars
     */
    @Override
    public void move() {
        super.move();
        for (int i = 0; i < cars.length; i++) {
            cars[i].move();
        }
    }


    /**
     *
     * @return the degrees
     */
    public double getDegrees() {
        return degrees;
    }


    /**
     * loads a car to the truck
     * @param c the car to be loaded
     */
    public void loadTruck(Car c) {

        if (isClose(c) && getDegrees() == 0 && !(c instanceof Loadable)) {
            addCar(c);
            c.setDirection(this.getDirection());
        }

    }

    /**
     * removes a car to the load
     * @return the ofloaded car
     */
    public Car unLoadTruck() {
            Car tmp = null;
        if (getDegrees() == 0) {
            tmp = getLastCar(cars);
            tmp.turnLeft();
            tmp.move();
        }
        return tmp;
    }



    /**
     * Adds a car to the load
     * @param c is the car to be loaded
     */
    public void addCar(Car c) {

        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = c;
                return;
            }
        }

    }

    /**
     * removes a car from the load
     * @param c the car to vbe removed
     * @return the removed car
     */
    public Car removeCar(Car c) {
        int index = 0;
        Car car;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] == c){
                index = i;
                car = cars[i];
                cars[i] = null;
                break;
            }
        }

        cleanArr(cars, index);
        return c;
    }

    private void cleanArr(Car[] cars, int index){

        for (int i = index + 1; i < cars.length; i++) {
            cars[i-1] = cars[i];
        }
        cars[cars.length - 1] = null;

    }

    private Car getLastCar(Car[] c){
        Car car = null;
        for (int i = 0; i < c.length; i++) {
            if(c[i] != null){
                car = c[i];
            }
        }
        return car;
    }

    public Car getFirstCar(){
        return cars[0];
    }


    private boolean isClose(Car c) {
        if (c.getX() - this.getX() <= 10 && c.getX() - this.getX() >= -10) {
            if (c.getY() - this.getY() <= 10 && c.getY() - this.getY() >= -10) {
                return true;
            }
        }
        return false;
    }

}
