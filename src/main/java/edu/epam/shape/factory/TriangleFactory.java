package edu.epam.shape.factory;

import edu.epam.shape.entity.Point2d;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.exception.ValidatorException;
import edu.epam.shape.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TriangleFactory {
    private static final Logger logger = LogManager.getLogger(TriangleFactory.class);
    private final TriangleValidator validator = new TriangleValidator();

    public Triangle createTriangle(Point2d a, Point2d b, Point2d c) throws ValidatorException {
        Triangle triangle = null;
        if (validator.isTriangle(a, b, c)) {
            triangle = new Triangle(a, b, c, UUID.randomUUID().toString().replace("-", ""));
        }
        logger.info("Triangle created " + triangle);
        return triangle;
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
        logger.info("Triangle list created " + triangleList);
        return triangleList;
    }
}
