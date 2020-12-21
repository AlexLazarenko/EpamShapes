package edu.epam.shape.repository.impl;

import edu.epam.shape.entity.Triangle;
import edu.epam.shape.repository.Repository;
import edu.epam.shape.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepositoryImpl implements Repository<Triangle> {//todo
    private List<Triangle> triangles = new ArrayList<>();

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
        Triangle triangle=null;
        for (Triangle element:triangles) {
            if (element.getName().equals(name)){
                 triangle=element;
            }
        }
        return triangle;
    }

    @Override
    public List<Triangle> sort(Comparator comparator) {
        return null;
    }

    @Override
    public List<Triangle> query(Specification specification) {
        return null;
    }
}
