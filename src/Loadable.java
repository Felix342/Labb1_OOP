public interface Loadable {

    double degrees = 0;

    /**
     * @Return the degrees of the load;
     */
    double getDegrees();

    /**
     * Lowers the load
     */
    void lowerLoad();

    /**
     * Raises the load
     */
    void raiseLoad();

}
