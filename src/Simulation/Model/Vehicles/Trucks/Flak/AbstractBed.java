package Simulation.Model.Vehicles.Trucks.Flak;

public abstract class AbstractBed {
    private double x;
    private double y;
    private double degrees = 0;

    public AbstractBed(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveBedWithOwner(double x, double y){
        this.x = x;
        this.y = y;
    }

    protected void setX(double x) {
        this.x = x;
    }

    protected void setY(double y) {
        this.y = y;
    }

    protected double getX() {
        return x;
    }

    protected double getY() {
        return y;
    }

    protected void raiseLoad(int amount) {
        if (degrees + amount >= 70)
            degrees = 70;
        else
            degrees += amount;
        //System.out.println("AbsBed " + amount + " : " + degrees);
    }

    protected void lowerLoad(int amount) {
        if (degrees - amount <= 0)
            degrees = 0;
        else
            degrees -= amount;

    }

    public double getDegrees(){
        return degrees;
    }


}
