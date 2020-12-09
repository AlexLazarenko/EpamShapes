package edu.epam.shape.validator;

import edu.epam.shape.entity.Triangle;
import edu.epam.shape.exception.ValidatorException;
import edu.epam.shape.utility.ShapeUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TriangleValidator {
    private static final Logger logger = LogManager.getLogger(TriangleValidator.class);

    public List<Triangle> validateList(List<Triangle> triangleList) {
        for (Triangle triangle:triangleList) {
            if(!isTriangle(triangle)){
                triangleList.remove(triangle);
            }
        }
        return triangleList;
    }

    public boolean isTriangle(Triangle triangle) {//throws ValidatorException {
        boolean isTriangle = true;
        double aTob = ShapeUtility.calculateDistance(triangle.getA(), triangle.getB());
        double bToc = ShapeUtility.calculateDistance(triangle.getB(), triangle.getC());
        double aToc = ShapeUtility.calculateDistance(triangle.getA(), triangle.getC());
        if (aTob > bToc + aToc || bToc > aTob + aToc || aToc > aTob + bToc) {// test imput data
            isTriangle = false;
            logger.warn("Triangle {} with sides {},{},{} can not exist! Wrong data!", triangle, aTob, bToc, aToc);
            // throw new ValidatorException("Triangle not exist wrong data");
        }
        logger.info("validation suc");
        return isTriangle;
    }
}