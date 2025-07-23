# Exercise 3 – Java Generics, Interfaces, and Type Safety

This project is part of an exercise where I worked with Java interfaces, abstract classes, and generics using multiple bounds. The implementation includes the interfaces `Winged` and `Bipedal`, the abstract class `Bird`, and the concrete class `Crow`. The `Exercise3.java` file demonstrates two methods, `challenge1` and `challenge2`, which at first seem to behave identically — but differ significantly in design.

---

### a) Language Feature: Java Generics with Multiple Interface Bounds

In the method `challenge2`, I used **Java generics** with multiple interface bounds: `<X extends Winged & Bipedal>`. This feature ensures that any object passed to the method implements **both** `Winged` and `Bipedal`.

- `challenge1(Bird b)` accepts any `Bird`, even if it doesn't explicitly guarantee both behaviors.
- `challenge2(X b)` provides stronger **compile-time safety** by requiring the passed object to implement **both interfaces explicitly**.

---

### b) Functional Differences Between `challenge1` and `challenge2`

Although both methods produce the same output, they differ in functionality and design principles:

| Feature               | `challenge1`                      | `challenge2`                                        |
|-----------------------|-----------------------------------|-----------------------------------------------------|
| Parameter Type        | Accepts only `Bird`               | Accepts any type implementing `Winged & Bipedal`    |
| Type Safety           | Weaker                            | Stronger, enforced at compile time                  |
| Flexibility           | Tied to class hierarchy           | Works with any class that satisfies interface bounds|
| Scalability           | Limited to `Bird` and subclasses  | More open to future expansion                       |

---

### c) My Example to Show Why `challenge2` is Better

To show the benefit of using `challenge2`, I created a **vehicle fleet system** where some objects can both fly and walk:

```java
interface Winged { void fly(); }
interface Bipedal { void walk(); }

abstract class Vehicle implements Winged, Bipedal { }

class FlyingRobot extends Vehicle {
    public void fly() { System.out.println("FlyingRobot flying."); }
    public void walk() { System.out.println("FlyingRobot walking."); }
}

class WalkingRobot extends Vehicle {
    public void fly() { System.out.println("WalkingRobot flying."); }
    public void walk() { System.out.println("WalkingRobot walking."); }
}

public class VehicleFleet {
    <X extends Winged & Bipedal> void manageVehicle(X vehicle) {
        vehicle.fly();
        vehicle.walk();
    }

    public static void main(String[] args) {
        new VehicleFleet().manageVehicle(new FlyingRobot());
        new VehicleFleet().manageVehicle(new WalkingRobot());
    }
}
