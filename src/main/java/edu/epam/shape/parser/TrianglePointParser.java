package edu.epam.shape.parser;

import edu.epam.shape.dto.TriangleCoordinates;
import edu.epam.shape.dto.TrianglePoints;
import edu.epam.shape.entity.Point2d;
import edu.epam.shape.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrianglePointParser {
    private static final Logger logger = LogManager.getLogger(TrianglePointParser.class);
    private static final String DELIMITER = "\\s+";
    private static final String NUMBER_REGEX = "^-?\\d*(\\.\\d+)?$";

    public List<TrianglePoints> pointsFromFile(List<TriangleCoordinates> coordinatesList) {
        List<TrianglePoints> trianglePointsList = new ArrayList<>();
        for (int i = 0; i < coordinatesList.size(); i++) {
            Point2d a = new Point2d(coordinatesList.get(i).getX(), coordinatesList.get(i).getY());
            Point2d b = new Point2d(coordinatesList.get(i).getZ(), coordinatesList.get(i).getZ());
            Point2d c = new Point2d(coordinatesList.get(i).getS(), coordinatesList.get(i).getD());
            TrianglePoints points=new TrianglePoints(a,b,c);
            trianglePointsList.add(points);
        }
        logger.info("Points list from file: " + trianglePointsList);
        return trianglePointsList;
    }

    public   List<String> filterData( List<String> numbers) throws ParserException { //todo
        for (int i=0; i< numbers.size(); i=i+6){
            if(!numbers.get(i).matches(NUMBER_REGEX)||!numbers.get(i+1).matches(NUMBER_REGEX)||
                    !numbers.get(i+2).matches(NUMBER_REGEX)||!numbers.get(i+3).matches(NUMBER_REGEX)||
                    !numbers.get(i+4).matches(NUMBER_REGEX)||!numbers.get(i+5).matches(NUMBER_REGEX)){
                numbers.remove(i); numbers.remove(i); numbers.remove(i);
                numbers.remove(i); numbers.remove(i); numbers.remove(i);
                logger.warn("Wrong data!Only double numbers resolved");
                throw new ParserException("Wrong data!Only double numbers resolved");
            }
        }
        return numbers;
    }

    public List<TriangleCoordinates> numbersFromFile(List<String> lines){
        List<TriangleCoordinates> triangleCoordinatesList=new ArrayList<>();
        for (String line : lines) {
            List<String>   numbers =new ArrayList<> (Arrays.asList(line.split(DELIMITER)));
           try {
                if (numbers.size() != 6) {
                    throw new ParserException("Wrong data!To create triangle three points needed!");//todo
                }else {
                  filterData(numbers);
                    for (int i=0; i< numbers.size(); i=i+6) {
                        double num1 = Double.parseDouble(numbers.get(i));
                        double num2 = Double.parseDouble(numbers.get(i+1));
                        double num3 = Double.parseDouble(numbers.get(i+2));
                        double num4 = Double.parseDouble(numbers.get(i+3));
                        double num5 = Double.parseDouble(numbers.get(i+4));
                        double num6 = Double.parseDouble(numbers.get(i+5));
                        TriangleCoordinates coordinates=new TriangleCoordinates(num1,num2,num3,num4,num5,num6);
                        triangleCoordinatesList.add(coordinates);
                    }
                }
            } catch (ParserException e) {
                logger.warn(e);
            }
        }return triangleCoordinatesList;
    }
}