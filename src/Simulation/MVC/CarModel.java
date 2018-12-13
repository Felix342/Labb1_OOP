package Simulation.MVC;

import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Saab95;
import Simulation.Vehicles.Cars.Volvo240;
import Simulation.Vehicles.Trucks.Scania;
import Simulation.Vehicles.Vehicle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarModel {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    List<Point> points = new ArrayList();
    Map<Point, Vehicle> pointBinder;

    private Vehicle currentVehicle;

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, Vehicle vehicle){
        currentVehicle = vehicle;
        if(x > 800-100){
            vehicle.stopEngine();
            vehicle.turnLeft();
            vehicle.turnLeft();
            vehicle.startEngine();
            vehicle.setX(800-100);
        }
        if(x < 0){
            vehicle.stopEngine();
            vehicle.turnLeft();
            vehicle.turnLeft();
            vehicle.startEngine();
            vehicle.setX(0);
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    private void init(){
        vehicles.add(new Volvo240(100, 0, Color.WHITE, 4));
        vehicles.add(new Scania(100, 0, Color.BLACK, 2));
        vehicles.add(new Saab95(200, 0, Color.RED, 2));
    }


    // Initializes the panel and reads the images
    public CarModel() {
        init();
        initMap(vehicles);

        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string

            volvoImage = ImageIO.read(new File("src\\Simulation\\Assets\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\Simulation\\Assets\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\Simulation\\Assets\\Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public void initMap(List<Vehicle> vehicles){
        pointBinder = new HashMap<>();
        for (int i = 0; i < vehicles.size(); i++) {

            vehicles.get(i).setY(50 + 100*i);
            Point p = new Point((int) vehicles.get(i).getY(), (int) vehicles.get(i).getY());
            points.add(p);
            pointBinder.put(p, vehicles.get(i));
        }
    }


    public BufferedImage getCarImage(Vehicle vehicle) throws IOException {

        BufferedImage vehicleImage = null;

        switch (vehicle.getModelName()){
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
}
