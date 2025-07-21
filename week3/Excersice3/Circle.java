package fi.utu.tech.exercise3.shapes;

import fi.utu.tech.exercise3.util.Point;

public class Circle implements Shape {
    private final Point center, perimeter;

    public Circle(Point center, Point perimeter) {
        this.center = center;
        this.perimeter = perimeter;
    }

    @Override
    public double area() {
        int dx = center.x() - perimeter.x();
        int dy = center.y() - perimeter.y();
        return Math.PI * (dx * dx + dy * dy);
    }

    @Override
    public Point topRight() {
        int radiusX = Math.abs(center.x() - perimeter.x());
        int radiusY = Math.abs(center.y() - perimeter.y());
        return new Point(center.x() + radiusX, center.y() + radiusY);
    }

    @Override
    public Point bottomLeft() {
        int radiusX = Math.abs(center.x() - perimeter.x());
        int radiusY = Math.abs(center.y() - perimeter.y());
        return new Point(center.x() - radiusX, center.y() - radiusY);
    }
}
