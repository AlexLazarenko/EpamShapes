package edu.epam.shape.factory;

import edu.epam.shape.entity.*;

public class TriangleFactory {
    public Triangle createTriangle(TriangleType type, Point2d a, Point2d b, Point2d c, String name)  {
        Triangle triangle = null;
        switch (type) {
            case EQUILATERAL:
                triangle = new EquilateralTriangle(a, b, c, name);
                break;
            case ISOSCELES:
                triangle = new IsoscelesTriangle(a, b, c, name);
                break;
            case SIMPLE:
                triangle = new SimpleTriangle(a, b, c, name);
                break;
        }
        return triangle;
    }
}
