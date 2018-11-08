import java.awt.*;

/**
 * A class describing a car of the model Volvo 240. Has a trimFactor which affects speedFactor.
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4,100, Color.black,"Volvo240");
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