package edu.epam.shape.entity;

import edu.epam.shape.action.Service;
import edu.epam.shape.exception.ValidatorException;
import edu.epam.shape.observer.Observable;
import edu.epam.shape.observer.Observer;
import edu.epam.shape.observer.impl.ObserverImpl;
import edu.epam.shape.validator.TriangleValidator;

public abstract class Triangle implements Observable<ObserverImpl> {
    private final TriangleValidator validator = new TriangleValidator();
    private final Service service=new Service();
    private Point2d a;
    private Point2d b;
    private Point2d c;
    private String name;
    private Observer<Triangle> observer;

    public Triangle(Point2d a, Point2d b, Point2d c, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.name = name;
    }

    public Point2d getA() {
        return a;
    }

    public void setA(Point2d a) throws ValidatorException {
        this.a = a;
        notifyObserver();
    }

    public Point2d getB() {
        return b;
    }

    public void setB(Point2d b) throws ValidatorException {
        this.b = b;
        notifyObserver();
    }

    public Point2d getC() {
        return c;
    }

    public void setC(Point2d c) throws ValidatorException {
        this.c = c;
        notifyObserver();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void attach(ObserverImpl observer) {
        this.observer = observer;
    }

    @Override
    public void detach(ObserverImpl observer) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() throws ValidatorException {
        if (observer != null) {
            if(validator.isTriangle(this)) {
             //   service.identifyTriangle(this);  //todo  change in repo?
                observer.performAngleType(this);
                observer.performPerimeter(this);
                observer.performSquare(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!a.equals(triangle.a)) return false;
        if (!b.equals(triangle.b)) return false;
        if (!c.equals(triangle.c)) return false;
        return name.equals(triangle.name);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}