package edu.epam.shape.observer;

import edu.epam.shape.exception.ValidatorException;

public interface Observable<T> {
    void attach(T observer);

    void detach(T observer);

    void notifyObserver() throws ValidatorException;
}
