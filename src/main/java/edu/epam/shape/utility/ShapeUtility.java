package edu.epam.shape.utility;

import edu.epam.shape.entity.Point2d;

public class ShapeUtility {

    public static double calculateDistance(Point2d a, Point2d b) {
        return Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY() * (b.getY() - a.getY())));
    }
}