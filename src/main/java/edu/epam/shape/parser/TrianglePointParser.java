package edu.epam.shape.parser;

import edu.epam.shape.entity.Point2d;
import edu.epam.shape.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TrianglePointParser {
    private static final Logger logger = LogManager.getLogger(TrianglePointParser.class);

    public List<Point2d> pointsFromFile(List<String> lines) {
        List<Point2d> point2DList = new ArrayList<>();
        List<Double> coordinatesList = new ArrayList<>();
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
        logger.info("Points list from file: " + point2DList);
        return point2DList;
    }
}