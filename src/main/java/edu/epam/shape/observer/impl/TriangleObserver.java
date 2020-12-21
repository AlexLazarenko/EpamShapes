package edu.epam.shape.observer.impl;

import edu.epam.shape.action.TriangleService;
import edu.epam.shape.dto.TriangleData;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.observer.Observer;
import edu.epam.shape.storage.TriangleDataStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserver implements Observer<Triangle> {
    private static final Logger logger = LogManager.getLogger(TriangleObserver.class);
    private final TriangleService triangleService = new TriangleService();
    private final TriangleDataStorage storage = TriangleDataStorage.getInstance();

    @Override
    public void performPerimeter(Triangle triangle) {
        TriangleData data = storage.readData(triangle.getName());
        data.setPerimeter(triangleService.calculatePerimeter(triangle));
        storage.update(triangle.getName(), data);
        logger.info("Perimeter of the triangle updated " + data);
    }

    @Override
    public void performSquare(Triangle triangle) {
        TriangleData data = storage.readData(triangle.getName());
        data.setSquare(triangleService.calculateSquare(triangle));
        storage.update(triangle.getName(), data);
        logger.info("Square of the triangle updated " + data);
    }

    @Override
    public void performAngleType(Triangle triangle) {
        TriangleData data = storage.readData(triangle.getName());
        data.setAngleType(triangleService.identifyAngleType(triangle));
        storage.update(triangle.getName(), data);
        logger.info("AngleType of the triangle updated " + data);
    }
}
