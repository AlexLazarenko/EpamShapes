package edu.epam.shape.reader;

import edu.epam.shape.utility.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeFileReader {
    private static final Logger logger = LogManager.getLogger(ShapeFileReader.class);


    public List<String> readFromFile(String dir) {
        List<String> lines = new ArrayList<>();
        File file = new File(PropertiesLoader.getProperty(dir));
        try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
        logger.info("String array with lines from file: " + lines);
        return lines;
    }
}