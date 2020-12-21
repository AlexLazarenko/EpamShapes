package edu.epam.shape.observer;

import edu.epam.shape.entity.Shape;

public interface Observer<T extends Shape> {
    void performPerimeter(T t);

    void performSquare(T t);

    void performAngleType(T t);
}
