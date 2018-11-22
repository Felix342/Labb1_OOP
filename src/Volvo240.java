import java.awt.*;

/**
 * A class describing a car of the model Volvo 240.
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName, nrDoors);
    }

    /**
     * Decides the speedFactor by calculating enginePower and potential trimFactor.
     * @return the speedFactor.
     */
    @Override
    public double getSpeedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}