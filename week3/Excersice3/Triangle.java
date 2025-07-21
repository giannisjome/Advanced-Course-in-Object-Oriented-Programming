package fi.utu.tech.exercise3.shapes;

import fi.utu.tech.exercise3.util.Point;

public class Triangle implements Shape {
    private final Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        int width = topRight().x() - bottomLeft().x();
        int height = topRight().y() - bottomLeft().y();
        return width * height / 2.0;
    }

    @Override
    public Point topRight() {
        int x = Math.max(a.x(), Math.max(b.x(), c.x()));
        int y = Math.max(a.y(), Math.max(b.y(), c.y()));
        return new Point(x, y);
    }

    @Override
    public Point bottomLeft() {
        int x = Math.min(a.x(), Math.min(b.x(), c.x()));
        int y = Math.min(a.y(), Math.min(b.y(), c.y()));
        return new Point(x, y);
    }
}
