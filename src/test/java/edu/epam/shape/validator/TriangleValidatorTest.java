package edu.epam.shape.validator;

import edu.epam.shape.entity.Point2d;
import edu.epam.shape.exception.ValidatorException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleValidatorTest {
    private TriangleValidator triangleValidator = new TriangleValidator();
    @Test
    public void isTriangleTrueTest() throws ValidatorException {
        Point2d a = new Point2d(1,3);
        Point2d b = new Point2d(2,-5);
        Point2d c = new Point2d(-8,4);
        boolean actual = triangleValidator.isTriangle(a,b,c);
        Assert.assertTrue(actual);
    }

    @Test
    public void isTriangleFalseTest() throws ValidatorException {
        Point2d a = new Point2d(1,1);
        Point2d b = new Point2d(2,2);
        Point2d c = new Point2d(3,3);
        boolean actual = triangleValidator.isTriangle(a,b,c);
        Assert.assertFalse(actual);
    }
}