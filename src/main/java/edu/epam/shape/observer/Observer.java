package edu.epam.shape.observer;

import edu.epam.shape.entity.Triangle;

public interface Observer <T extends Triangle> {
    void performPerimeter(T t);
    void performSquare(T t);
    void performAngleType(T t);
}
