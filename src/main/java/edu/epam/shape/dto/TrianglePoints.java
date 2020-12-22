package edu.epam.shape.dto;

import edu.epam.shape.entity.Point2d;

public class TrianglePoints {
    private Point2d a;
    private Point2d b;
    private Point2d c;

    public TrianglePoints(Point2d a, Point2d b, Point2d c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point2d getA() {
        return a;
    }

    public void setA(Point2d a) {
        this.a = a;
    }

    public Point2d getB() {
        return b;
    }

    public void setB(Point2d b) {
        this.b = b;
    }

    public Point2d getC() {
        return c;
    }

    public void setC(Point2d c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrianglePoints that = (TrianglePoints) o;

        if (!a.equals(that.a)) return false;
        if (!b.equals(that.b)) return false;
        return c.equals(that.c);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TrianglePoints{");
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append('}');
        return sb.toString();
    }
}
