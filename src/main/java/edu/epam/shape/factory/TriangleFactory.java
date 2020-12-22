package edu.epam.shape.factory;

import edu.epam.shape.dto.TrianglePoints;
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

    public List<Triangle> createTrianglesFromList(List<TrianglePoints> points2DList) throws ValidatorException {
        List<Triangle> triangleList = new ArrayList<>();
        for (TrianglePoints trianglePoints : points2DList) {
            if (trianglePoints != null){
            Triangle triangle = createTriangle(trianglePoints.getA(),
                    trianglePoints.getB(), trianglePoints.getC());
                triangleList.add(triangle);
            }
        }
        logger.info("Triangle list created " + triangleList);
        return triangleList;
    }
}
