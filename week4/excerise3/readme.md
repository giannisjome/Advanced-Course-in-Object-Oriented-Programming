# Exercise 3 

This project demonstrates the use of interfaces, abstract classes, and generics with multiple bounds in Java through the classes `Winged`, `Bipedal`, `Bird`, and `Crow`. The file `Exercise3.java` showcases two methods, `challenge1` and `challenge2`, which at first glance appear to perform the same functionality — invoking `fly()` and `walk()` — but differ significantly in their design and implications.

---

## Key Concepts

### a) Language Feature: Java Generics with Multiple Interface Bounds

The method `challenge2` uses **Java generics** with multiple interface bounds: `<X extends Winged & Bipedal>`. This enforces that the input object must implement both interfaces, `Winged` and `Bipedal`.

- `challenge1(Bird b)` relies on the class hierarchy — it accepts any subclass of `Bird`, regardless of whether it strictly implements both interfaces.
- `challenge2(X b)` ensures at **compile time** that the argument has both required behaviors (`fly()` and `walk()`), increasing **type safety** and **flexibility**.

---

### b) Functional Differences Between `challenge1` and `challenge2`

Despite similar runtime behavior, these methods differ in:

| Aspect                | `challenge1`                     | `challenge2`                                      |
|-----------------------|----------------------------------|--------------------------------------------------|
| Parameter Type        | Accepts `Bird`                   | Accepts any type implementing `Winged & Bipedal` |
| Type Safety           | Weaker (relies on `Bird`)        | Stronger (interface-based constraints)           |
| Flexibility           | Tightly coupled to `Bird` class  | Decoupled, supports any valid combination        |
| Interface Dependency  | Implicit                         | Explicit and enforced                            |

---

### c) Demonstration of `challenge2`'s Advantages

To demonstrate the benefits of the `challenge2` method, we implemented a **Vehicle Fleet** scenario:

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
