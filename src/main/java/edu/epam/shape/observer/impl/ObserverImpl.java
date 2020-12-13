package edu.epam.shape.observer.impl;

import edu.epam.shape.action.Service;
import edu.epam.shape.dto.TriangleData;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.observer.Observer;
import edu.epam.shape.storage.TriangleDataStorage;

public class ObserverImpl implements Observer<Triangle> {
    private final Service service = new Service();
    TriangleDataStorage storage = TriangleDataStorage.getInstance();

    @Override
    public void performPerimeter(Triangle triangle) {
        TriangleData data = storage.readData(triangle.getName());
        data.setPerimeter(service.calculatePerimeter(triangle));
        storage.update(triangle.getName(), data);
    }

    @Override
    public void performSquare(Triangle triangle) {
        TriangleData data = storage.readData(triangle.getName());
        data.setSquare(service.calculateSquare(triangle));
        storage.update(triangle.getName(), data);
    }

    @Override
    public void performAngleType(Triangle triangle) {
        TriangleData data = storage.readData(triangle.getName());
        data.setAngleType(service.identifyAngleType(triangle));
        storage.update(triangle.getName(),data);

    }
}
