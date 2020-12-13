package edu.epam.shape.dto;

public class TriangleData {
    private double perimeter;
    private double square;
    private String angleType;

    public TriangleData(double perimeter, double square, String angleType) {
        this.perimeter = perimeter;
        this.square = square;
        this.angleType = angleType;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public String getAngleType() {
        return angleType;
    }

    public void setAngleType(String angleType) {
        this.angleType = angleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriangleData that = (TriangleData) o;

        if (Double.compare(that.perimeter, perimeter) != 0) return false;
        if (Double.compare(that.square, square) != 0) return false;
        return angleType.equals(that.angleType);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(perimeter);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(square);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + angleType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleData{");
        sb.append("perimeter=").append(perimeter);
        sb.append(", square=").append(square);
        sb.append(", angleType='").append(angleType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
