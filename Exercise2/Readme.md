# Library Book Database - Access Control via Encapsulation and Interfaces

This system simulates an in-memory book database for a library, where `Book` objects are stored in memory using a `List<Book>`. The design supports two user roles:

1. **Library Customers** – allowed only to search and view book information.  
2. **Library Staff** – allowed to view and also **edit** book information, such as correcting errors or marking a book as lost.

---

## Goal

I wanted to ensure that **only authorized users** (staff) can update book information, while others (customers) can only **view** book details safely. To achieve this, I needed to clearly separate reading and writing responsibilities in the system.

---

## Principle of Data Protection

I applied **Encapsulation** along with **Interface Segregation**:

- I kept the internal state of each book (`title`, `publicationYear`, `publisher`) private.
- I created two interfaces to restrict access depending on the user role:
  - `ReadOnlyBook` for customers
  - `EditableBook` for staff

This allowed me to cleanly separate access control in the system without duplicating code or exposing unnecessary functionality to the wrong users.

---

## Mechanism Overview

### Interfaces

```java
public interface ReadOnlyBook {
    String getTitle();
    int getPublicationYear();
    String getPublisher();
}
