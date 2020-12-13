package edu.epam.shape.validator;

import edu.epam.shape.entity.Point2d;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.exception.ValidatorException;
import edu.epam.shape.utility.ShapeUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TriangleValidator {
    private static final Logger logger = LogManager.getLogger(TriangleValidator.class);

 /*   public List<Triangle> validateList(List<Triangle> triangleList) throws ValidatorException {
        for (Triangle triangle : triangleList) {
            if (!isTriangle(triangle)) {
                triangleList.remove(triangle);
            }
        }
        return triangleList;
    }*/

    public boolean isTriangle(Point2d a, Point2d b, Point2d c) throws ValidatorException {
        boolean isTriangle = true;
        double aTob = ShapeUtility.calculateDistance(a, b);
        double bToc = ShapeUtility.calculateDistance(b, c);
        double aToc = ShapeUtility.calculateDistance(a, c);
        if (aTob > bToc + aToc || bToc > aTob + aToc || aToc > aTob + bToc) {// test input data
            try{
                throw new ValidatorException("Triangle not exist wrong data");//todo
            } catch (ValidatorException e){
                isTriangle = false;
                logger.warn("Triangle with sides {},{},{} can not exist! Wrong data!", aTob, bToc, aToc);
            }
        }
        logger.info("validation successful");
        return isTriangle;
    }
    public boolean isTriangle(Triangle triangle) throws ValidatorException {
        boolean isTriangle = true;
        double aTob = ShapeUtility.calculateDistance(triangle.getA(), triangle.getB());
        double bToc = ShapeUtility.calculateDistance(triangle.getB(), triangle.getC());
        double aToc = ShapeUtility.calculateDistance(triangle.getA(), triangle.getC());
        if (aTob > bToc + aToc || bToc > aTob + aToc || aToc > aTob + bToc) {// test input data
            try{
                throw new ValidatorException("Triangle not exist wrong data");//todo
            } catch (ValidatorException e){
                isTriangle = false;
                logger.warn("Triangle with sides {},{},{} can not exist! Wrong data!", aTob, bToc, aToc);
            }
        }
        logger.info("validation successful");
        return isTriangle;
    }
}