package Simulation.Model.Vehicles.Trucks;

import java.awt.*;

public class TruckFactory {

    public static Truck createMANG90(double enginePower, double currentSpeed, Color color, int nrDoors){
        return MANG90.createMANG90(enginePower, currentSpeed, color, nrDoors);
    }

    public static Truck createScania(double enginePower, double currentSpeed, Color color, int nrDoors){
        return Scania.createScania(enginePower, currentSpeed, color, nrDoors);
    }

}
