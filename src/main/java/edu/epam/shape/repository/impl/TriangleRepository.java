package edu.epam.shape.repository.impl;

import edu.epam.shape.entity.Triangle;
import edu.epam.shape.repository.Repository;
import edu.epam.shape.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository implements Repository<Triangle> {
    private static TriangleRepository instance;
    private List<Triangle> triangles = new ArrayList<>();

    private TriangleRepository() {
    }

    public static TriangleRepository getInstance() {
        if (instance == null) {
            instance = new TriangleRepository();
        }
        return instance;
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
    }

    @Override
    public void remove(Triangle triangle) {
        triangles.remove(triangle);
    }

    @Override
    public Triangle get(String name) {
        Triangle triangle = null;
        for (Triangle element : triangles) {
            if (element.getName().equals(name)) {
                triangle = element;
            }
        }
        return triangle;
    }

    @Override
    public List<Triangle> sort(Comparator<? super Triangle> comparator) {
        List<Triangle> listResult = new ArrayList<>(triangles);
        listResult.sort(comparator);
        return listResult;
    }

    @Override
    public List<Triangle> query(Specification<Triangle> specification, double squareFrom, double squareTo) {
        List<Triangle> listResult = triangles.stream().filter(o -> specification.
                specifyBySquare(o, squareFrom, squareTo)).collect(Collectors.toList());
        return listResult;
    }
}
