package Simulation.MVC;

public class Application {

    public static void main(String[] args) {

        CarModel model = new CarModel();
        CarView view = new CarView("CarSim 1.0", model);
        CarController controller = new CarController(model, view);

    }

}
