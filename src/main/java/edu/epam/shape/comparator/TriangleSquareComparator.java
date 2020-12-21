package edu.epam.shape.comparator;

import edu.epam.shape.dto.TriangleData;
import edu.epam.shape.entity.Triangle;
import edu.epam.shape.storage.TriangleDataStorage;

import java.util.Comparator;

public class TriangleSquareComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle t1, Triangle t2) {
        TriangleData dataT1= TriangleDataStorage.getInstance().readData(t1.getName());
        TriangleData dataT2= TriangleDataStorage.getInstance().readData(t2.getName());
        Double squareT1= dataT1.getSquare();
        Double squareT2= dataT2.getSquare();
        return squareT1.compareTo(squareT2);  //todo
    }
}