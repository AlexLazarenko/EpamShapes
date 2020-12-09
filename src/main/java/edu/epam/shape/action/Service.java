package edu.epam.shape.action;

import edu.epam.shape.entity.Triangle;
import edu.epam.shape.utility.ShapeUtility;

public class Service {
    public String identifyTriangle(Triangle triangle){
        //todo
        /*
        if (a == c && a == b) {// identify triangle
            System.out.print("Equilateral triangle");
        } else if (a == b && a != c) {
            System.out.print("Isosceles triangle");
        } else if (a == c && a != b) {
            System.out.print("Isosceles triangle");
        } else if (b == c && c != a) {
            System.out.print("Isosceles triangle");
        } else {
            System.out.print("Simple triangle");
        }*/
        return "";
    }

    public double calculatePerimeter(Triangle triangle){
        double aTob = ShapeUtility.calculateDistance(triangle.getA(), triangle.getB());
        double bToc = ShapeUtility.calculateDistance(triangle.getB(), triangle.getC());
        double aToc = ShapeUtility.calculateDistance(triangle.getA(), triangle.getC());
        double perimeter=aTob+bToc+aToc;
        return perimeter;
    }

    public double calculateSquare(Triangle triangle){
        double aTob = ShapeUtility.calculateDistance(triangle.getA(), triangle.getB());
        double bToc = ShapeUtility.calculateDistance(triangle.getB(), triangle.getC());
        double aToc = ShapeUtility.calculateDistance(triangle.getA(), triangle.getC());
        double square=aTob+bToc+aToc;//todo
                return square;
    }
}