public class Trailer {
    private Car[] cars = new Car[10];

    /**
     * loads a car to the truck
     * @param c the car to be loaded
     */
    public void load(Car c) {

        if (!(c instanceof Loadable)) {
            addCar(c);
        }

    }

    /**
     * unloads a car
     * @return the offloaded car
     */
    public Car unLoad(Car c) {
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



    /**
     * Adds a car to the load
     * @param c is the car to be loaded
     */
    private void addCar(Car c) {

        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = c;
                return;
            }
        }

    }

    private void cleanArr(Car[] cars, int index){

        for (int i = index + 1; i < cars.length; i++) {
            cars[i-1] = cars[i];
        }
        cars[cars.length - 1] = null;

    }

    /**
     *
     * @return the first car in load
     */
    public Car getFirstCar(){
        return cars[0];
    }

    /**
     *
     * @return the last car in load
     */
    public Car getLastCar(){
        Car car = null;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null){
                car = cars[i];
            }
        }
        return car;
    }

}
