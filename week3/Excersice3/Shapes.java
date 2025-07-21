package fi.utu.tech.exercise3.shapes;

import fi.utu.tech.exercise3.util.Point;

public interface Shape {
    double area();
    Point topRight();
    Point bottomLeft();
}
