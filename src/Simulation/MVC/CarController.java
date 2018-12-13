package Simulation.MVC;

import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Saab95;
import Simulation.Vehicles.Trucks.Scania;
import Simulation.Vehicles.Cars.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    //methods:


    public CarController(CarModel model, CarView view) {
        this.model = model;
        this.frame = view;
    }

    private void init(){

        // Start the timer
        timer.start();
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gas = ((double) frame.gasSpinner.getValue()) / 100;
                for (Car car : model.getCars()) {
                    car.gas(gas);
                }
            }
        });

        frame.startButton.addActionListener( event ->{
            for (Car c : model.getCars()) {
                c.startEngine();
            }
        });

        frame.stopButton.addActionListener( event ->{
            for (Car c : model.getCars()) {
                c.stopEngine();
            }
        });

        frame.brakeButton.addActionListener( event ->{
            double brake = ((double) frame.gasSpinner.getValue()) / 100;
            for (Car car : model.getCars()) {
                car.brake(brake);
            }
        });

        frame.turboOffButton.addActionListener( event ->{
            for (Car c : model.getCars()) {
                if(c instanceof Saab95) {
                    ((Saab95) c).setTurboOff();
                }
            }
        });

        frame.turboOnButton.addActionListener( event ->{
            for (Car c : model.getCars()) {
                if(c instanceof Saab95) {
                    ((Saab95) c).setTurboOn();
                }
            }
        });

        frame.liftBedButton.addActionListener( event ->{
            for (Car c : model.getCars()) {
                if(c instanceof Scania) {
                    ((Scania) c).raiseLoad();
                }
            }
        });

        frame.lowerBedButton.addActionListener( event ->{
            for (Car c : model.getCars()) {
                if(c instanceof Scania) {
                    ((Scania) c).lowerLoad();
                }
            }
        });
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : model.getCars()) {
                car.move();

                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                model.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel

            }
            frame.repaint();
        }
    }

}