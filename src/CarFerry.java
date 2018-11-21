public class CarFerry implements Loadable{
    private Trailer trailer = new Trailer();

    /**
     * loads a car to the ferry
     * @param c the car to be loaded
     */
    @Override
    public void load(Car c) {
        trailer.load(c);
    }


    /**
     *
     * @return the unloaded car
     */
    @Override
    public Car unLoad(Car c) {
        return trailer.unLoad(trailer.getFirstCar());
    }
}
