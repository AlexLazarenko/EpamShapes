package edu.epam.shape.storage;

import edu.epam.shape.dto.TriangleData;

import java.util.HashMap;

public class TriangleDataStorage {
    private static TriangleDataStorage instance;
    private final HashMap<String, TriangleData> map = new HashMap<String, TriangleData>();

    private TriangleDataStorage() {
    }

    public static TriangleDataStorage getInstance() {
        if (instance == null) {
            instance = new TriangleDataStorage();
        }
        return instance;
    }

    public void create(String name, TriangleData data) {
        map.put(name, data);
    }

    public HashMap<String, TriangleData> readMap() {
        return new HashMap<String, TriangleData>(map);
    }

    public TriangleData readData(String name) {
        return map.get(name);
    }

    public void update(String name, TriangleData data) {
        map.put(name, data);
    }

    public void delete(String name) {
        map.remove(name);
    }
}
