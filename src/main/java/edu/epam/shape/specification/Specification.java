package edu.epam.shape.specification;

import edu.epam.shape.entity.Shape;

public interface Specification<T extends Shape> {
    boolean specifyBySquare(T t, double squareFrom, double squareTo);
}
