package edu.epam.shape.observer;

import edu.epam.shape.exception.ValidatorException;

public interface Observable<Observer> {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver() throws ValidatorException;
}
