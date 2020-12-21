package edu.epam.shape.utility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PropertiesLoaderTest {

    @Test
    public void testGetProperty() {
        String expected = "src/test/resources/file/file.txt";
        String actual = PropertiesLoader.getProperty("testFile.dir");
        assertEquals(actual, expected);
    }
}