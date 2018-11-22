public class Bed {

    protected Loadable owner;
    private double degrees = 0;

    public Bed(Loadable owner) {
        this.owner = owner;
    }

    /**
     * @return degrees of the load
     */
    public double getDegrees() {
        return degrees;
    }

    /**
     * Raise the load
     */
    public void raiseLoad(int amount) {
       //TODO skaffa currentspeed och se till att man inte kan raise eller lowera under movement.
        // if(owner.get)
        if (degrees + amount >= 70)
            degrees = 70;
        else
            degrees += amount;
    }

    /**
     * Lower the load
     */
    public void lowerLoad(int amount) {
        if (degrees - amount <= 0)
            degrees = 0;
        else
            degrees -= amount;

    }
}
