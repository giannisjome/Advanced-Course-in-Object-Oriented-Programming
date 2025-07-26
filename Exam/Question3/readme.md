# Question 3
This document analyzes which **Java class constructions** are most suitable for the given tasks and provides justifications for the chosen options while explaining why other alternatives are less appropriate.

---

## **a) Customer Database Query**

We want to query the customer database for clients registered in 2024.  
The database query returns a list of entries, where each entry consists of five attributes:  
**Name, Address, Email Address, Purchased Product, Purchase Date.**

### **Chosen Class Construction:** `record`

A **Java `record`** is ideal because:
- It is a *data carrier* class with minimal boilerplate.
- Records are immutable, which is suitable for data retrieved from a database.
- They automatically implement `equals`, `hashCode`, and `toString`, ensuring value-based semantics.

**Example:**
```java
public record Entry(
    String name,
    String address,
    String email,
    String purchasedProduct,
    LocalDate purchaseDate
) {}
```

## **Why Not Other Options? (Part a)**

- **Plain class:** Requires writing getters, `equals`, and `hashCode` manually.  
- **Interface/abstract class:** Not needed since we are not modeling behavior.  
- **Enum:** Only suitable for fixed constants, not variable data like database entries.


## **b) Reusable Filtering Logic**

We want to operate on the `List<Entry>` from the customer database and filter out all clients whose purchase date is **before January 2023**.  
The remaining list contains customers **eligible for a loyalty reward**. Instead of writing the filter logic repeatedly, it should be reusable.

### **Chosen Class Construction:** `Predicate<Entry>` (Functional Interface)

A **functional interface** is ideal because:
- It represents a **boolean-valued function** that can be reused across different filters.
- `Predicate<Entry>` is part of `java.util.function` and works seamlessly with **Streams**.
- Filters become **concise and composable** using functional style.

### **Example:**
```java
Predicate<Entry> eligibleForLoyalty =
    e -> !e.purchaseDate().isBefore(LocalDate.of(2023, 1, 1));

List<Entry> result = entries.stream()
    .filter(eligibleForLoyalty)
    .toList();
```
# Why Not Other Options?

- **Abstract/base class with a filter method:** Too heavyweight for a single boolean function.  
- **Static utility methods:** Not composable or reusable in a flexible way.  
- **Enum or record:** These describe data, not behavior.



## **c) Financial Transactions**

We want to model **financial transactions with value semantics**.  
Transactions include different types such as **Deposit**, **Withdrawal**, and **Transfer**.  
The transaction should display **type-specific information**, e.g., *"Deposit of $100"* or *"Withdrawal of €50"*.


### **Chosen Class Construction:** `sealed interface` + `record` subtypes

A **sealed interface** with **record implementations** is ideal because:
- It allows **polymorphic behavior** (e.g., type-specific `toString`).
- Records provide **immutability and value semantics**.
- Sealing ensures that only known subclasses (**Deposit**, **Withdrawal**, **Transfer**) exist, which allows **exhaustive pattern matching**.
