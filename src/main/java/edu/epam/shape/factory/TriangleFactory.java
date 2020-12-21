package edu.epam.shape.factory;

import edu.epam.shape.action.TriangleService;
import edu.epam.shape.entity.*;
import edu.epam.shape.exception.ValidatorException;
import edu.epam.shape.validator.TriangleValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TriangleFactory {
    private final TriangleValidator validator = new TriangleValidator();
    private final TriangleService triangleService = new TriangleService();

    public Triangle createTriangle(Point2d a, Point2d b, Point2d c) throws ValidatorException {
        if (validator.isTriangle(a, b, c)) {
            TriangleType type = triangleService.identifyTriangle(a, b, c);
            Triangle triangle = null;
            switch (type) {
                case EQUILATERAL:
                    triangle = new EquilateralTriangle(a, b, c, UUID.randomUUID().toString().replace("-", ""));
                    break;
                case ISOSCELES:
                    triangle = new IsoscelesTriangle(a, b, c, UUID.randomUUID().toString().replace("-", ""));
                    break;
                case SIMPLE:
                    triangle = new SimpleTriangle(a, b, c, UUID.randomUUID().toString().replace("-", ""));
                    break;
            }
            return triangle;
        } else return null;
    }

    public List<Triangle> createTrianglesFromList(List<Point2d> point2DList) throws ValidatorException {
        List<Triangle> triangleList = new ArrayList<>();
        for (int i = 0; i < point2DList.size(); i++) {
            Triangle triangle = createTriangle(point2DList.get(i),
                    point2DList.get(i + 1), point2DList.get(i + 2));
            i = i + 2;
            if (triangle != null) {
                triangleList.add(triangle);
            }
        }
        return triangleList;
    }
}
