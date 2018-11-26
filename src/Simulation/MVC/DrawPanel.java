package Simulation.MVC;

import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Saab95;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    // To keep track of a singel cars position
    List<Point> points = new ArrayList();

    Point volvoPoint = new Point(100, 20);
    Point saabPoint = new Point(200, 10);

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, Car car){
        if(car instanceof Saab95){

            saabPoint.x = x;
            saabPoint.y = y;

        }

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\Simulation\\Assets\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\Simulation\\Assets\\Saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        points.add(new Point(100, 20));
        points.add(new Point(200, 10));

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);



    }
}