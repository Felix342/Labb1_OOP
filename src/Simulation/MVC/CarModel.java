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
    // To keep track of a singel cars position
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static int ÄNDRANAMN = 0;

    List<Point> points = new ArrayList();
    Map<Point, Vehicle> pointBinder;

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
            Vehicle vehicle = vehicles.get(vehicles.size()-1);
            vehicles.remove(vehicle);
            pointBinder.remove(vehicle);
            ÄNDRANAMN--;
        }
    }

    public void addCar() {
        if(vehicles.size() < 10) {
            Vehicle vehicle = VehicleFactory.createVolvo240(600, 0, Color.WHITE, 4);
            vehicles.add(vehicle);
            addCarToMap(vehicle);
        }
    }


    // Initializes the panel and reads the images
    public CarModel() {

        vehicles.add(VehicleFactory.createVolvo240(100, 0, Color.WHITE, 4));
        vehicles.add(VehicleFactory.createSaab95(100, 0, Color.BLACK, 2));
        vehicles.add(VehicleFactory.createScania(200, 0, Color.RED, 2));

        initMap(vehicles);

    }

    private void addCarToMap(Vehicle vehicle) {
        vehicle.setY(50 + 100 * ÄNDRANAMN);
        ÄNDRANAMN++;
        Point p = new Point((int) vehicle.getY(), (int) vehicle.getY());
        points.add(p);
        pointBinder.put(p, vehicle);
    }

    private void initMap(List<Vehicle> vehicles) {

        pointBinder = new HashMap<>();
        for (int i = 0; i < vehicles.size(); i++) {
            addCarToMap(vehicles.get(i));
        }

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
