package fi.utu.tech.exercise3.shapes;

import fi.utu.tech.exercise3.util.Point;

public class Quadrilateral implements Shape {
    private final Point a, b;

    public Quadrilateral(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        int width = Math.abs(a.x() - b.x());
        int height = Math.abs(a.y() - b.y());
        return width * height;
    }

    @Override
    public Point topRight() {
        return new Point(Math.max(a.x(), b.x()), Math.max(a.y(), b.y()));
    }

    @Override
    public Point bottomLeft() {
        return new Point(Math.min(a.x(), b.x()), Math.min(a.y(), b.y()));
    }
}
