# Exercise 2 – Inheritance, Polymorphism, and Reuse in Java

## a.) Inheritance and Polymorphism

### Inheritance
- `WeirdProblem` and `TrickyProblem` inherit from `Problem`, which itself inherits from `Exception`.
- This hierarchy allows structured exception handling based on specificity.

### Polymorphism
- In `Experiment2`, the `perform()` method declares `throws Problem`, but may throw a `WeirdProblem` or `TrickyProblem`.
- This demonstrates polymorphism — using a superclass type (`Problem`) to refer to subclass instances at runtime.

### Catch Blocks
- Catching must be done from the most specific to the most general:
  ```java
  catch (WeirdProblem w) {}
  catch (TrickyProblem w) {}
  catch (Problem w) {}
