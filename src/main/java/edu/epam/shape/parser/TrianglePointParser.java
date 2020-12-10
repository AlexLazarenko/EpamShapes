package edu.epam.shape.parser;

import edu.epam.shape.entity.Point2d;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.exception.ParserException;
import edu.epam.shape.exception.ValidatorException;
import edu.epam.shape.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TrianglePointParser {
    private static final Logger logger = LogManager.getLogger(TrianglePointParser.class);

    public List<Triangle> trianglesFromFile(List<String> lines) throws ValidatorException, ParserException { //throws ParserException {
        List<Triangle> triangleList = new ArrayList<>();
        List<Point2d> point2DList= new ArrayList<>();
        List<Double> coordinatesList=new ArrayList<>();
        for (String line : lines) {
            String[] numbers = line.split("\\s+");
            try {
                if (numbers.length!=6){
                      throw new ParserException("Wrong data!To create triangle three points needed!");//todo
                }
            }catch (ParserException e){
                logger.warn(e);
            }
            for (String number : numbers) {
                if (number.matches("\\d+$")) {
                    double num = Double.parseDouble(number);
                    coordinatesList.add(num);
                }
            }
        }
        for(int i=0;i<coordinatesList.size();i++){
            Point2d point=new Point2d(coordinatesList.get(i),coordinatesList.get(i+1));
            point2DList.add(point);
            i++;
        }
        for(int i=0;i<point2DList.size();i++){
            Triangle triangle=new Triangle(point2DList.get(i),point2DList.get(i+1),point2DList.get(i+2) );
            triangleList.add(triangle);
            i=i+2;
        }
        TriangleValidator validator=new TriangleValidator();
        validator.validateList(triangleList);
        logger.info("Triangle list from file: " + triangleList);
        return triangleList;
    }
}