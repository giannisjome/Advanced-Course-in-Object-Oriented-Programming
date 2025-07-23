# Exercise 1

##  a.) Go through each class and describe what construct it represents

### 1. `Exercise1`
- **Construct**: Concrete `public` class  
- **Represents**: A demo/driver class. Runs the zip-processing logic inside a `try-with-resources` block using a `TestZipper`.

### 2. `TestZipper`
- **Construct**: Concrete subclass of `Zipper`  
- **Represents**: A test or custom behavior implementation of `Zipper`. It overrides the abstract method `createHandler(...)` to define how each file should be processed.

### 3. `Zipper`
- **Construct**: `abstract public class` that implements `AutoCloseable`  
- **Represents**: A base class for unzipping logic. Manages the lifecycle of a temporary directory and processes ZIP entries using `Handler` objects.

### 4. `Handler`
- **Construct**: `protected abstract static class Handler`  
- **Represents**: A strategy interface in abstract class form. Used to define different ways to process each extracted file.  
- **Nested**: Static and nested within `Zipper`.

---

##  b.) Why was each construct chosen?

| Class       | Construct                      | Why                                                                                       |
|-------------|--------------------------------|--------------------------------------------------------------------------------------------|
| `Exercise1` | Simple public class            | Needed only to demonstrate the behavior; no extension or polymorphism necessary.          |
| `TestZipper`| Subclass of `Zipper`           | Provides a specific implementation of `createHandler(Path)` to define file behavior. Enables separation of concerns. |
| `Zipper`    | `abstract` class               | Encapsulates shared logic for handling ZIP files. Abstract to require customization via `createHandler(...)`. Implements `AutoCloseable` to manage temp dir lifecycle. |
| `Handler`   | `protected abstract static` class | Forces subclasses (e.g., anonymous classes in `TestZipper`) to define how a file is handled. `static` allows instantiation without access to outer `Zipper`. `protected` hides it from outside packages but lets subclasses use it. |

---

##  c.) Temporary Directory Lifespan and Class Relation

- The `Zipper` constructor creates a temporary directory using `Files.createTempDirectory(...)`.
- The `close()` method deletes that directory when the object is closed.
- This matches the object lifecycle:
  - The directory exists **only while** the `Zipper` (or subclass like `TestZipper`) is alive.
- Use of `try-with-resources` in `Exercise1` ensures automatic cleanup, linking directory lifetime directly to the object lifetime.



---

## 🔹 d.) Why `protected abstract static class Handler`, and how is `static` appropriate?

| Keyword     | Reason                                                                 |
|-------------|------------------------------------------------------------------------|
| `protected` | Makes the class accessible only to subclasses of `Zipper` and other classes in the same package. Encourages encapsulated extensibility. |
| `abstract`  | Forces implementing classes (like the one returned in `TestZipper`) to define the `handle()` method. Enforces a contract. |
| `static`    | Since `Handler` is defined inside `Zipper`, making it `static` means it does **not** require an instance of `Zipper` to be instantiated. It behaves like a top-level class logically grouped within `Zipper`. This is appropriate because a `Handler` should work on its own and not depend on the specific state of a `Zipper` instance. |


