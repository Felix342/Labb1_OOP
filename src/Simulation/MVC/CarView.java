package Simulation.MVC;

import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Vehicle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JPanel{
    private static final int X = 800;
    private static final int Y = 800;

    private CarModel model;

    JPanel controlPanel = new JPanel();
    JFrame window = new JFrame();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Simulation.Vehicles.Trucks.Flak.Bed");
    JButton lowerBedButton = new JButton("Lower Lift Simulation.Vehicles.Trucks.Flak.Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    JButton addCarButton = new JButton("Add Car");
    JButton removeCarButton = new JButton("Remove Car");

    // Constructor
    public CarView(String framename, CarModel model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(X, Y-240));
        this.setBackground(Color.green);
        initComponents(framename);
        this.model = model;
        //this.model.initMap(cars);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        window.setTitle(title);
        window.setPreferredSize(new Dimension(X,Y));
        window.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        window.add(this);



        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        window.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        window.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        window.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        window.add(stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        window.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        window.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        window.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < model.points.size(); i++) {

            Vehicle vehicle = model.pointBinder.get(model.points.get(i));
            try {
                g.drawImage(model.getCarImage(vehicle), (int) vehicle.getX(), (int) vehicle.getY(), null); // see javadoc for more info on the parameters
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}