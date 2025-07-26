# Question 2

# Java Inheritance, Polymorphism, and Design Analysis

This project explores how **inheritance** and **polymorphism** are manifested in exception handling (Part A) and analyzes a currency converter implementation from a design perspective (Part B).



## **Part A: Inheritance and Polymorphism in Exceptions**

### **Scenario**
We define a hierarchy of AI-related exceptions:
```java
abstract class AIException extends Exception {}
class DataProcessingError extends AIException {}
class ModelTrainingError extends AIException {}

##Two pipeline classes demonstrate how these exceptions are thrown:##
```java
class AIPipeline {
    void run() throws DataProcessingError, ModelTrainingError { ... }
}

class AIPipeline2 {
    void run() throws AIException { ... }
}
```
###The main() method demonstrates catching these exceptions:###
```java
try {
    pipeline1.run();
    pipeline2.run();
}
catch (DataProcessingError dp) {}
catch (ModelTrainingError mt) {}
catch (AIException ae) {}
```

# Key Points

## **Inheritance**
- `DataProcessingError` and `ModelTrainingError` extend `AIException`, forming an exception hierarchy.

## **Polymorphism**
- The `catch (AIException ae)` block can handle any subclass of `AIException`.

## **AIPipeline vs. AIPipeline2**
- `AIPipeline` declares **specific exceptions**, requiring multiple catch blocks.
- `AIPipeline2` declares a **general exception (AIException)**, allowing simpler handling and better extensibility.

---

# **Part B: Currency Converter Analysis**

## **Given Code**
```java
class CurrencyConverter {
    Object convert(double amount, String currency) {
        return switch (currency) {
            case "€" -> amount * 1.1;
            case "GBP" -> amount * 0.9;
            case "JPY" -> amount * 110;
            default -> amount * 2;
        };
    }
}

class SpecificCurrencyConverter extends CurrencyConverter {
    @Override
    Double convert(double amount, String currency) {
        return amount * 1.2;
    }
}
