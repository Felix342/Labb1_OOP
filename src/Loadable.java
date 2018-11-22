public interface Loadable {
    Car[] cars = new Car[10];
   //TODO Klura ut varför och hur? Yolo man-
    // Bed bed = null;

    /**
     * Lowers the load
     */
    void load(Car c);

    /**
     * Raises the load
     */
    Car unLoad();

    double getX();
    double getY();
}


