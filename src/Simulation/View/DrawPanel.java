package Simulation.View;

import Simulation.Model.CarModel;
import Simulation.Model.Vehicles.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DrawPanel extends JPanel {
    // This method is called each time the panel updates/refreshes/repaints itself

    CarView view;

    public DrawPanel(CarView view){
        this.view = view;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle vehicle : model.getVehicles()) {

            try {
                g.drawImage(model.getCarImage(vehicle), (int) vehicle.getX(), (int) vehicle.getY(), null); // see javadoc for more info on the parameters
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
