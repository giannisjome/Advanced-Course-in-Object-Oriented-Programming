# Föli Java Card System – Functional Model Specification

## Overview

This project models the **public transportation payment card system** for **Turku regional public transportation Föli**, implemented in Java as a simulation. It enables operations like:

* Loading funds to a card.
* Checking the balance.
* Purchasing various types of tickets (Single, Day, Monthly).
* Ensuring ticket validity using synchronized system time.

This abstract model demonstrates the core behavior of a real-world transport fare system in a **modular, maintainable, and extensible way**, ready for integration with physical infrastructure.

---

## System Components and Responsibilities

### 1. `FoliCard` (The Card)

**Responsibility:**
Models a passenger's payment card.

**Main Features:**

* Maintains balance (in `double`).
* Holds an active ticket (`Ticket` object).
* Provides methods to:

  * Load money.
  * Check current balance.
  * Buy a new ticket (if valid one isn’t active).
  * Check ticket validity.

**Design Choices:**

* Encapsulates state via private variables.
* Guardrails ensure business logic is followed (e.g., no duplicate valid tickets).

---

### 2. `Ticket` (Purchased Ticket)

**Responsibility:**
Models a purchased ticket with expiration time and type.

**Main Features:**

* Stores ticket **type** (enum `TicketType`).
* Records the **purchase time** in system milliseconds.
* Calculates **expiration** based on duration.
* Can report whether it is still **valid**.

**Design Choices:**

* Immutable after creation (ensures consistency).
* Uses `System.currentTimeMillis()` for time tracking.

---

### 3. `TicketType` (Ticket Options)

**Responsibility:**
An enumeration defining valid types of tickets and their properties.

**Types:**

* SINGLE (3€, 2 hours)
* DAY (8€, 24 hours)
* MONTH (55€, 30 days)

**Main Features:**

* Stores fixed **price** and **duration in ms** for each type.

**Design Justification:**

* Enum simplifies extensibility and validation of ticket properties.
* Prevents hardcoded values elsewhere in the system.

---

### 4. `CardReader` (Interaction Device)

**Responsibility:**
Simulates the bus or service point interface that interacts with a `FoliCard`.

**Main Features:**

* Presents ticket purchase options.
* Deducts the correct fare if sufficient balance.
* Prevents ticket purchase if:

  * Card has an active valid ticket.
  * Card has insufficient balance.

**Design Principles:**

* Separates interface logic from card data logic.
* Models a real-world reader interface that processes logic based on input and card state.

---

### 5. `MainProgramme` (System Driver)

**Responsibility:**
Simulates user interaction and demonstrates the flow of operations.

**Main Features:**

* Creates a `FoliCard`.
* Simulates loading balance.
* Attempts ticket purchases.
* Checks for valid tickets.
* Displays outcomes to the user.

**Design Justification:**

* Provides a testbed for simulating real-world scenarios.
* Easy to extend or convert into unit tests or web-based UI in future development phases.

---

## Encapsulation and Invariants

* All class fields are private to enforce data integrity.
* Access is only available via public getter and logic methods.
* Invariant: A `FoliCard` may only have **zero or one active ticket**.
* Invariant: A new ticket can be added only if:

  * No valid ticket is active.
  * Balance is sufficient.

---

## Communication Between Classes

* `CardReader` interacts with `FoliCard` using public methods.
* `FoliCard` delegates time-related logic to `Ticket`.
* `Ticket` uses `TicketType` for pricing and duration values.
* `MainProgramme` simulates real-world events by calling `CardReader`.

---

## Time Management

* Time is measured with `System.currentTimeMillis()` in milliseconds.
* Each `TicketType` defines its duration in ms:

  * Single ticket: \~7,200,000 ms (2 hours)
  * Day ticket: \~86,400,000 ms (24 hours)
  * Monthly ticket: \~2,592,000,000 ms (30 days)
* This approach ensures ticket expiration is based on actual system time.

---

## Design Advantages

* **Extensibility**: New ticket types or device logic can be easily added.
* **Reusability**: Shared logic is encapsulated in reusable methods.
* **Encapsulation**: Prevents accidental data manipulation.
* **Separation of Concerns**: Logic split clearly between data (e.g., `FoliCard`), business rules (e.g., `Ticket`), and interaction (`CardReader`).

---



