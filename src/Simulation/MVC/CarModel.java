package Simulation.MVC;

import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Saab95;
import Simulation.Vehicles.Cars.Volvo240;
import Simulation.Vehicles.Trucks.Scania;

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
    ArrayList<Car> cars = new ArrayList<>();
    java.util.List<Point> points = new ArrayList();
    Map<Point, Car> pointBinder;

    private Car currentCar;

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, Car car){
        currentCar = car;
        if(x > 800-100){
            car.stopEngine();
            car.turnLeft();
            car.turnLeft();
            car.startEngine();
            car.setX(800-100);
        }
        if(x < 0){
            car.stopEngine();
            car.turnLeft();
            car.turnLeft();
            car.startEngine();
            car.setX(0);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    private void init(){
        cars.add(new Volvo240(100, 0, Color.WHITE, 4));
        cars.add(new Scania(100, 0, Color.BLACK, 2));
        cars.add(new Saab95(200, 0, Color.RED, 2));
    }


    // Initializes the panel and reads the images
    public CarModel() {

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

    public void initMap(List<Car> cars){
        pointBinder = new HashMap<>();
        for (int i = 0; i < cars.size(); i++) {

            cars.get(i).setY(50 + 100*i);
            Point p = new Point((int) cars.get(i).getY(), (int) cars.get(i).getY());
            points.add(p);
            pointBinder.put(p, cars.get(i));
        }
    }


    public BufferedImage getCarImage(Car car) throws IOException {

        BufferedImage carImage = null;

        switch (car.getModelName()){

            case ("Volvo240"):
                carImage = ImageIO.read(new File("src\\Simulation\\Assets\\Volvo240.jpg"));
                break;

            case ("Saab95"):
                carImage = ImageIO.read(new File("src\\Simulation\\Assets\\Saab95.jpg"));
                break;

            case ("Scania"):
                carImage = ImageIO.read(new File("src\\Simulation\\Assets\\Scania.jpg"));
                break;

            default:
                break;

        }

        return carImage;
    }


}
