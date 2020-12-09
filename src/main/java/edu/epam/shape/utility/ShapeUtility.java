package edu.epam.shape.utility;

import edu.epam.shape.entity.Point2d;

public class ShapeUtility {

    public static double calculateDistance(Point2d a, Point2d b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
}