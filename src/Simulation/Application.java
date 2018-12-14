package Simulation;

import Simulation.Controller.CarController;
import Simulation.Model.CarModel;
import Simulation.View.CarView;
import Simulation.View.DrawPanel;

public class Application {

    public static void main(String[] args) {

        CarModel model = new CarModel();
        CarView view = new CarView("CarSim 1.0", model);
        DrawPanel panel = new DrawPanel(view);
        CarController controller = new CarController(model, view);

    }

}
