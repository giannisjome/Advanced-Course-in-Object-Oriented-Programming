# Library Book Database - Access Control via Encapsulation and Interfaces

This project simulates an in-memory book database for a library. All book data is stored in memory using a `List<Book>`, and the system distinguishes between two types of users:

1. **Library Customers** – can search for and read book information.
2. **Library Staff** – can search for, read, and also edit book information (e.g. correcting data, marking books as lost, etc.).

---

## Goal

I developed this system to ensure that **only authorized users** (staff) can update book information, while others (customers) can only **view** book details. My goal was to design a simple yet effective way to separate read and write access to the `Book` data.

---

## Principle of Data Protection

I applied the principle of **Encapsulation**, combined with **Interface Segregation**:

- I made all internal fields in the `Book` class private.
- I created a `ReadOnlyBook` interface to provide a limited view of book data for customers.
- I exposed full access (including setters) only to staff who use the `Book` class directly.

This ensured that customers never have access to operations that modify book data, while staff members have full control when needed.

---

## Files I Developed

###  `ReadOnlyBook.java`

This interface provides read-only access to a book’s properties:

```java
public interface ReadOnlyBook {

  String getTitle();
    int getPublicationYear();
    String getPublisher();
}

###  `Book.java`

This class implements the ReadOnlyBook interface and includes additional setters for editing book data. I used encapsulation to protect the internal state and added validation inside the setters to ensure the integrity of the data.

### 'BookDatabase.java'
This class simulates the book database using a List<Book>. I provided different views of the books for different user roles:
