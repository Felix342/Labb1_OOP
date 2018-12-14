package Simulation.MVC;

import Simulation.Vehicles.Cars.Saab95;
import Simulation.Vehicles.Trucks.Truck;
import Simulation.Vehicles.Vehicle;
import Simulation.Vehicles.VehicleFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class CarModel {
    // To keep track of a single cars position
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static int offset = 0;
    private static final Random rand = new Random();

    void moveit(int x, int y, Vehicle vehicle) {
        if (x > 800 - 100) {
            vehicle.stopEngine();
            vehicle.turnLeft();
            vehicle.turnLeft();
            vehicle.startEngine();
            vehicle.setX(800 - 100);
        }
        if (x < 0) {
            vehicle.stopEngine();
            vehicle.turnLeft();
            vehicle.turnLeft();
            vehicle.startEngine();
            vehicle.setX(0);
        }
    }

    public void removeCar(){
        if(vehicles.size() > 0){
            vehicles.remove(vehicles.size()-1);
            offset--;
        }
    }

    public void addCar(){

        switch (rand.nextInt(3)){
            case 0:
                addCar(VehicleFactory.createScania(200, 0, Color.RED, 2));
                break;
            case  1:
                addCar(VehicleFactory.createSaab95(200, 0, Color.RED, 2));
                break;
            case 2:
                addCar(VehicleFactory.createVolvo240(200, 0, Color.RED, 2));
                break;

                default:
                    break;
        }

    }

    public void addCar(Vehicle vehicle) {
        if(vehicles.size() < 10) {
            vehicles.add(vehicle);
            vehicle.setY(50 + 70 * offset);
            offset++;
        }
    }

    public CarModel() {
        addCar(VehicleFactory.createScania(200, 0, Color.RED, 2));
        addCar(VehicleFactory.createSaab95(100, 0, Color.BLACK, 2));
        addCar(VehicleFactory.createVolvo240(100, 0, Color.WHITE, 4));
    }


    public BufferedImage getCarImage(Vehicle vehicle) throws IOException {

        BufferedImage vehicleImage = null;

        switch (vehicle.getModelName()) {
            case ("Volvo240"):
                vehicleImage = ImageIO.read(new File("src\\Simulation\\Assets\\Volvo240.jpg"));
                break;
            case ("Saab95"):
                vehicleImage = ImageIO.read(new File("src\\Simulation\\Assets\\Saab95.jpg"));
                break;
            case ("Scania"):
                vehicleImage = ImageIO.read(new File("src\\Simulation\\Assets\\Scania.jpg"));
                break;
            default:
                break;
        }
        return vehicleImage;
    }

    public List<Vehicle> getVehicles() {
        List<Vehicle> vehiclesCopy = new ArrayList<>();
        for (Vehicle v: vehicles) {
            vehiclesCopy.add(v);
        }
        return vehiclesCopy;
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void startCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void brakeCar(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                ((Truck) vehicle).lowerLoad();
            }
        }
    }

    void raiseBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                ((Truck) vehicle).raiseLoad();
            }
        }
    }

    public void update() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getX());
            int y = (int) Math.round(vehicle.getY());
            moveit(x, y, vehicle);
        }
    }

}
