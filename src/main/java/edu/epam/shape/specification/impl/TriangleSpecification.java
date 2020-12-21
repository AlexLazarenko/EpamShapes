package edu.epam.shape.specification.impl;

import edu.epam.shape.dto.TriangleData;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.specification.Specification;
import edu.epam.shape.storage.TriangleDataStorage;

public class TriangleSpecification implements Specification<Triangle> {
    @Override
    public boolean specifyBySquare(Triangle triangle, double squareFrom, double squareTo) {
        TriangleData data = TriangleDataStorage.getInstance().readData(triangle.getName());
        double square = data.getSquare();
        return (square >= squareFrom && square <= squareTo);
    }
}
