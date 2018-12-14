package Simulation.Vehicles;

import Simulation.Vehicles.Cars.CarFactory;
import Simulation.Vehicles.Trucks.TruckFactory;

import java.awt.*;

public class VehicleFactory {

    public static Vehicle createVolvo240(double enginePower, double currentSpeed, Color color, int nrDoors){
        return CarFactory.createVolvo240(enginePower, currentSpeed, color, nrDoors);
    }

    public static Vehicle createSaab95(double enginePower, double currentSpeed, Color color, int nrDoors){
        return CarFactory.createSaab95(enginePower, currentSpeed, color, nrDoors);
    }

    public static Vehicle createMANG90(double enginePower, double currentSpeed, Color color, int nrDoors){
        return TruckFactory.createMANG90(enginePower, currentSpeed, color, nrDoors);
    }

    public static Vehicle createScania(double enginePower, double currentSpeed, Color color, int nrDoors){
        return TruckFactory.createScania(enginePower, currentSpeed, color, nrDoors);
    }

    public static Vehicle createCarFerry(double enginePower, double currentSpeed, Color color){
        return CarFerry.createCarFerry(enginePower, currentSpeed, color);
    }
}
