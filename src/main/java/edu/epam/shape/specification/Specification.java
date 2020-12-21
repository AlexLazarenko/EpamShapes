package edu.epam.shape.specification;

import edu.epam.shape.entity.Triangle;

public interface Specification<T extends Triangle> {
    boolean specifyBySquare(T t, double squareFrom, double squareTo);
}
