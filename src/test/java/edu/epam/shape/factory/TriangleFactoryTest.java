package edu.epam.shape.factory;

import edu.epam.shape.entity.Point2d;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.exception.ValidatorException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleFactoryTest {
    TriangleFactory triangleFactory = new TriangleFactory();
    @Test
    public void createShapeTest() throws ValidatorException {
        Point2d p1 = new Point2d(1,3);
        Point2d p2 = new Point2d(2,-5);
        Point2d p3 = new Point2d(-8,4);
        Triangle actual = triangleFactory.createTriangle(p1,p2,p3);
        Assert.assertNotNull(actual);
    }

    @Test
    public void createShapeErrorTest() throws ValidatorException {
        Point2d p1 = new Point2d(1,1);
        Point2d p2 = new Point2d(2,2);
        Point2d p3 = new Point2d(3,3);
        Triangle actual = triangleFactory.createTriangle(p1,p2,p3);
        Assert.assertNull(actual);
    }

}