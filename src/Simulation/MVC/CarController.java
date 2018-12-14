package Simulation.MVC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private CarModel model;
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed



    public CarController(CarModel model, CarView view) {
        this.model = model;
        this.frame = view;
        init();
    }

    private void init() {
        // Start the timer
        timer.start();
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = (int) frame.gasSpinner.getValue();
                model.gas(i);
            }
        });

        frame.startButton.addActionListener(event -> {
            model.startCars();
        });

        frame.stopButton.addActionListener(event -> {
            model.stopCars();
        });

        frame.brakeButton.addActionListener(event -> {
            int i = (int) frame.gasSpinner.getValue();
            model.brakeCar(i);
        });

        frame.turboOffButton.addActionListener(event -> {
            model.turboOff();
        });

        frame.turboOnButton.addActionListener(event -> {
            model.turboOn();
        });

        frame.liftBedButton.addActionListener(event -> {
            model.raiseBed();
        });

        frame.lowerBedButton.addActionListener(event -> {
            model.lowerBed();
        });

        frame.addCarButton.addActionListener(event -> {
            model.addCar();
        });

        frame.removeCarButton.addActionListener(event -> {
            model.removeCar();
        });


    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();
            frame.repaint();
        }
    }

}