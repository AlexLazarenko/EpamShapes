package edu.epam.shape.reader;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ShapeFileReaderTest {
    private ShapeFileReader shapeFileReader = new ShapeFileReader();

    @Test
    public void testReadFromFile() {
        List<String> actual = shapeFileReader.readFromFile("testFile.dir");
        List<String> expected = new ArrayList<>();
        String str1 = "1a 1 2 2 3 3.0";
        String str2 = "1 1 2 2 3 3.0";
        String str3 = "0 0 1 1 2 2";
        String str4 = "0 0 1 1 2";
        String str5 = "1 3 2 -5 -8 4";
        String str6 = "-2 2 3 2 -1 0";
        String str7 = "0 0 0 3 2 0";
        String str8 = "0 0 1 1 0 2";
        expected.add(str1);
        expected.add(str2);
        expected.add(str3);
        expected.add(str4);
        expected.add(str5);
        expected.add(str6);
        expected.add(str7);
        expected.add(str8);
        assertEquals(actual, expected);
    }
}