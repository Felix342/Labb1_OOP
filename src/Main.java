import javax.swing.*;

/**
 * Description: A factory producing cars. Kind of...
 *
 * @Author Mattias, Einar och Felix.
 * @version 0.240
 * @since 2018-11-08
 */

public class Main {

    public static void main(String[] args){
        Volvo240 skrot = new Volvo240();
        Saab95 lyxbil = new Saab95();

        lyxbil.setTurboOn();

        System.out.println(lyxbil.getNrDoors());
        System.out.println(skrot.getColor());

        skrot.startEngine();
        skrot.turnLeft();
        skrot.move();
        System.out.println(skrot.getX());
        System.out.println(skrot.getY());

        lyxbil.setTurboOff();
        System.out.println(lyxbil.getCurrentSpeed());

        lyxbil.gas(1);
        System.out.println(lyxbil.getCurrentSpeed());
        lyxbil.gas(0.7);
        System.out.println(lyxbil.getCurrentSpeed());
        lyxbil.brake(1);

        System.out.println(lyxbil.getCurrentSpeed());

    }
}
