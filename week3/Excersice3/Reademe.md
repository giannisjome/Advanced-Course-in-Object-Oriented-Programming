# Exercise 3 – Refactored with Object-Oriented Principles

This Java program refactors the original shape-handling logic using object-oriented design. The goal is to improve **maintainability**, **extensibility**, and **clarity** by organizing code according to shape-specific responsibilities.

## Features

- Supports different shape types (`Triangle`, `Quadrilateral`, `Circle`)
- Reads an arbitrary number of shapes from the user
- Calculates area and boundary box for each shape
- Designed to easily support more shape types or geometric operations in the future

## Structure

- `Shape` interface defines core operations (`area`, `topRight`, `bottomLeft`)
- Each shape class implements `Shape` and encapsulates its own logic
- `Exercise3` is the main program that dynamically processes user input and operates on shapes via polymorphism

## Justification

- **Open/Closed Principle**:  
  New shapes (e.g., `Hexagon`) can be added by implementing `Shape` without changing any existing logic in the main program.

- **Polymorphism**:  
  Methods like `area()` and `getBoundaries()` are called uniformly on any object that implements the `Shape` interface, enabling flexible handling of diverse shapes.

- **Maintainability**:  
  Each shape encapsulates its behavior in a separate class. This separation of concerns makes the codebase easier to debug, update, or expand.

- **Scalability**:  
  The number of shapes is not fixed—users can input any number of shapes. Additionally, new operations (e.g., `perimeter()`, `translate(dx, dy)`) can be added to the `Shape` interface and implemented incrementally across shapes.

## Usage

Run the `Exercise3` class. Follow the prompts to enter shapes. Type `done` when finished. The program will display:

- The total area of all shapes
- The combined bounding box covering all shapes

## Requirements

- Java 17+
