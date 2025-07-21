package fi.utu.tech.exercise3;

import fi.utu.tech.exercise3.shapes.*;
import fi.utu.tech.exercise3.util.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A circle is defined by a center and a perimeter point. Others by corner points.");

        List<Shape> shapes = new ArrayList<>();

        while (true) {
            System.out.print("Enter the pattern type (triangle, quadrilateral, circle) or 'done': ");
            String type = scanner.next().toLowerCase();
            if (type.equals("done")) break;

            Shape shape = switch (type) {
                case "triangle" -> new Triangle(readPoint(scanner), readPoint(scanner), readPoint(scanner));
                case "quadrilateral" -> new Quadrilateral(readPoint(scanner), readPoint(scanner));
                case "circle" -> new Circle(readPoint(scanner), readPoint(scanner));
                default -> {
                    System.out.println("Unknown shape. Try again.");
                    continue;
                }
            };
            shapes.add(shape);
        }

        double totalArea = shapes.stream().mapToDouble(Shape::area).sum();
        System.out.printf("Total area of all patterns: %.2f\n", totalArea);

        if (!shapes.isEmpty()) {
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

            for (Shape s : shapes) {
                Point tr = s.topRight();
                Point bl = s.bottomLeft();

                maxX = Math.max(maxX, tr.x());
                maxY = Math.max(maxY, tr.y());
                minX = Math.min(minX, bl.x());
                minY = Math.min(minY, bl.y());
            }

            System.out.printf("Common boundaries:\n(%d, %d) x (%d, %d)\n", minX, minY, maxX, maxY);
        }
    }

    private static Point readPoint(Scanner scanner) {
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
        return new Point(x, y);
    }
}
