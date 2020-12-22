package edu.epam.shape.parser;

import edu.epam.shape.entity.Point2d;
import edu.epam.shape.reader.ShapeFileReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class TrianglePointParserTest {
    private ShapeFileReader shapeFileReader = new ShapeFileReader();
    private TrianglePointParser parser=new TrianglePointParser();

    @Test
    public void testTrianglesFromFile() {
        List<String> preActual = shapeFileReader.readFromFile("testFile.dir");
     //todo   List<Point2d> actual=parser.pointsFromFile(preActual);
        List<Point2d> expected= Arrays.asList(new Point2d(1.0, 2.0), new Point2d(2.0, 3.0), new Point2d(1.0, 1.0),
                new Point2d(2.0, 2.0), new Point2d(3.0, 0.0), new Point2d(0.0, 1.0), new Point2d(1.0, 2.0),
                new Point2d(2.0, 0.0), new Point2d(0.0, 1.0), new Point2d(1.0, 2.0), new Point2d(1.0, 3.0),
                new Point2d(2.0, 4.0), new Point2d(2.0, 3.0), new Point2d(2.0, 0.0), new Point2d(0.0, 0.0),
                new Point2d(0.0, 3.0), new Point2d(2.0, 0.0), new Point2d(0.0, 0.0), new Point2d(1.0, 1.0),
                new Point2d(0.0, 2.0));
   //     assertEquals(actual, expected);
        }

    @Test
    public void testFilterData() {
        List<String> preActual = shapeFileReader.readFromFile("testFile.dir");

    }

    @Test
    public void testNumbersFromFile() {
        List<String> preActual = shapeFileReader.readFromFile("testFile.dir");
   //todo     List<Double> actual=parser.numbersFromFile(preActual);
    //    System.out.println(actual);
    }
}

