public interface Loadable {
    Car[] cars = new Car[10];

    /**
     * Lowers the load
     */
    void load(Car c);

    /**
     * Raises the load
     */
    Car unLoad(Car c);

}
