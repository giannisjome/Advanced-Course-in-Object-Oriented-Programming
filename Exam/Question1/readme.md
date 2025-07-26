# Question 1

This project is a simple in-memory database for a fan website of the digital card game **FireStone**. It allows two types of users to interact with the card database:

1. **Players** – can only search and view card details (read-only access).
2. **Administrative Staff** – can edit or update card information (write access).

The system demonstrates **encapsulation** and **role-based access control (RBAC)** to ensure data integrity and prevent unauthorized modifications.

---

## **Features**
- **Card Data**: Each card has fields like `title`, `cost`, `type`, and `damage`.
- **Player Access**:
  - Read-only access through `getter` methods.
  - No modification methods are exposed to players.
- **Admin Access**:
  - Ability to edit card details via `editCard()` method.
  - Built-in validation to maintain class invariants (e.g., no negative cost or damage).

---

## **Design Principles**
- **Encapsulation**: All card attributes are private. Access to data is restricted via controlled getter and setter methods.
- **Role Separation**:
  - Players only interact with `Card` objects using read methods (`getTitle()`, `getCost()`, etc.).
  - Admins can edit card attributes using the `editCard()` method, which checks admin privileges.
- **Class Invariant Protection**: All updates go through validation to ensure data consistency.

---

## **Class Overview**
### **Card**
Represents a card in the FireStone game.

**Fields:**
- `title` (String)
- `cost` (int)
- `type` (String)
- `damage` (int)

**Methods:**
- `getTitle()`, `getCost()`, `getType()`, `getDamage()` – read-only access for all users.
- `editCard(title, cost, type, damage, isAdmin)` – allows admin users to modify card information.

---

## **Usage Example**

### **Player**
```java
Card card = new Card("Fireball", 4, "Spell", 6);
System.out.println("Card Name: " + card.getTitle());
```

### **Admin**
```java
Card card = new Card("Fireball", 4, "Spell", 6);
card.editCard("Flame Burst", 5, "Spell", 7, true);
```
