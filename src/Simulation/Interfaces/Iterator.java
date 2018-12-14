package Simulation.Interfaces;

public interface Iterator<T> {

    boolean hasNext();
    T next();
    void remove();
}
