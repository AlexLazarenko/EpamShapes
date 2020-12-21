package edu.epam.shape.action;

import edu.epam.shape.entity.Point2d;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.entity.TriangleType;
import edu.epam.shape.utility.ShapeUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleService {
    private static final Logger logger = LogManager.getLogger(TriangleService.class);

    public TriangleType identifyTriangle(Point2d a, Point2d b, Point2d c) {
        TriangleType type;
        double aTob = ShapeUtility.calculateDistance(a, b);
        double bToc = ShapeUtility.calculateDistance(b, c);
        double aToc = ShapeUtility.calculateDistance(a, c);
        if (aTob == aToc && aTob == bToc) {// identify triangle
            type = TriangleType.EQUILATERAL;
        } else if ((aTob == bToc && aTob != aToc) || (aTob == aToc && aTob != bToc) || (bToc == aToc && aToc != aTob)) {
            type = TriangleType.ISOSCELES;
        } else {
            type = TriangleType.SIMPLE;
        }
        logger.info("Type of the triangle is "+type);
        return type;
    }

    public TriangleType identifyTriangle(Triangle triangle) {
        TriangleType type;
        double aTob = ShapeUtility.calculateDistance(triangle.getA(), triangle.getB());
        double bToc = ShapeUtility.calculateDistance(triangle.getB(), triangle.getC());
        double aToc = ShapeUtility.calculateDistance(triangle.getA(), triangle.getC());
        if (aTob == aToc && aTob == bToc) {// identify triangle
            type = TriangleType.EQUILATERAL;
        } else if ((aTob == bToc && aTob != aToc) || (aTob == aToc && aTob != bToc) || (bToc == aToc && aToc != aTob)) {
            type = TriangleType.ISOSCELES;
        } else {
            type = TriangleType.SIMPLE;
        }
        logger.info("Type of the triangle is "+type);
        return type;
    }

    public String identifyAngleType(Triangle triangle) {
        String type = "";
        double a = 0;
        double b = 0;
        double c = 0;
        double result;
        double aTob = ShapeUtility.calculateDistance(triangle.getA(), triangle.getB());
        double bToc = ShapeUtility.calculateDistance(triangle.getB(), triangle.getC());
        double aToc = ShapeUtility.calculateDistance(triangle.getA(), triangle.getC());
        if (aTob >= bToc && aTob >= aToc) {
            c = aTob;
            a = bToc;
            b = aToc;
        } else if (bToc >= aTob && bToc >= aToc) {
            c = bToc;
            a = aTob;
            b = aToc;
        } else if (aToc >= aTob && aToc >= bToc) {
            c = aToc;
            a = aTob;
            b = bToc;
        } else if (aTob == bToc && aTob != aToc && aToc < aTob) {
            c = aToc;
            a = aTob;
            b = bToc;
        } else if (aTob == aToc && aTob != bToc && bToc < aTob) {
            c = bToc;
            a = aTob;
            b = aToc;
        } else if (bToc == aToc && aToc != aTob && aTob < bToc) {
            c = aTob;
            a = aToc;
            b = bToc;
        }
        result = Math.pow(c, 2) - Math.pow(a, 2) - Math.pow(b, 2);
        if (result < 0) {
            type = "sharp-angled";
        } else if (result == 0) {
            type = "right-angled";
        } else type = "obtuse";
        logger.info("Angle type of the triangle is "+type);
        return type;
    }

    public double calculatePerimeter(Triangle triangle) {
        double aTob = ShapeUtility.calculateDistance(triangle.getA(), triangle.getB());
        double bToc = ShapeUtility.calculateDistance(triangle.getB(), triangle.getC());
        double aToc = ShapeUtility.calculateDistance(triangle.getA(), triangle.getC());
        double perimeter = aTob + bToc + aToc;
        logger.info("Perimeter of the triangle is "+perimeter);
        return perimeter;
    }

    public double calculateSquare(Triangle triangle) {
        double aTob = ShapeUtility.calculateDistance(triangle.getA(), triangle.getB());
        double bToc = ShapeUtility.calculateDistance(triangle.getB(), triangle.getC());
        double aToc = ShapeUtility.calculateDistance(triangle.getA(), triangle.getC());
        double square = Math.sqrt(calculatePerimeter(triangle) / 2 *
                (calculatePerimeter(triangle) / 2 - aTob) *
                (calculatePerimeter(triangle) / 2 - bToc) *
                (calculatePerimeter(triangle) / 2 - aToc));
        logger.info("Square of the triangle is "+square);
        return square;
    }
}