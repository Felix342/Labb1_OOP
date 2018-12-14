package Simulation.Vehicles.Cars;

import Simulation.Vehicles.Vehicle;

import java.awt.*;

public class CarFactory {

    public static Car createVolvo240(double enginePower, double currentSpeed, Color color, int nrDoors){
        return Volvo240.createVolvo240(enginePower, currentSpeed, color, nrDoors);
    }

    public static Car createSaab95(double enginePower, double currentSpeed, Color color, int nrDoors){
        return Saab95.createSaab95(enginePower, currentSpeed, color, nrDoors);
    }
}
