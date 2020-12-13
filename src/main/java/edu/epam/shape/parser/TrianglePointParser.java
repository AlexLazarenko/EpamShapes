package edu.epam.shape.parser;

import edu.epam.shape.action.Service;
import edu.epam.shape.entity.Point2d;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.exception.ParserException;
import edu.epam.shape.exception.ValidatorException;
import edu.epam.shape.factory.TriangleFactory;
import edu.epam.shape.factory.TriangleType;
import edu.epam.shape.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TrianglePointParser {
    private static final Logger logger = LogManager.getLogger(TrianglePointParser.class);
    private final TriangleFactory factory = new TriangleFactory();
    private final Service service = new Service();
    private final TriangleValidator validator = new TriangleValidator();

    public List<Triangle> trianglesFromFile(List<String> lines) throws ValidatorException {
        List<Triangle> triangleList = new ArrayList<>();
        List<Point2d> point2DList = new ArrayList<>();
        List<Double> coordinatesList = new ArrayList<>();
        TriangleType type;
        for (String line : lines) {
            String[] numbers = line.split("\\s+");
            try {
                if (numbers.length != 6) {
                    throw new ParserException("Wrong data!To create triangle three points needed!");//todo
                }
            } catch (ParserException e) {
                logger.warn(e);
            }
            for (String number : numbers) {
                if (number.matches("\\d+$")) {
                    double num = Double.parseDouble(number);
                    coordinatesList.add(num);
                }
            }
        }
        for (int i = 0; i < coordinatesList.size(); i++) {
            Point2d point = new Point2d(coordinatesList.get(i), coordinatesList.get(i + 1));
            point2DList.add(point);
            i++;
        }
        for (int i = 0; i < point2DList.size(); i++) {
            if (validator.isTriangle(point2DList.get(i), point2DList.get(i + 1), point2DList.get(i + 2))) {
                type = service.identifyTriangle(point2DList.get(i), point2DList.get(i + 1), point2DList.get(i + 2));
                Triangle triangle = factory.createTriangle(type, point2DList.get(i),
                        point2DList.get(i + 1), point2DList.get(i + 2),
                        UUID.randomUUID().toString().replace("-", ""));
                triangleList.add(triangle);
            }
            i = i + 2;
        }
        logger.info("Triangle list from file: " + triangleList);
        return triangleList;
    }
}