# Book Sorting 

This project is part of an exercise where I implemented a `Book` class and demonstrated multiple ways to sort a collection of books based on different criteria. The task focused on using Java’s object-oriented principles, generics, interfaces, and the Collections API.

---

## A) `Book` Class Implementation

I created a `Book` class that represents a book file with the following properties:

- **Name**: The first line of the file (used as the book's title).
- **Line Count**: The total number of lines in the file.
- **Unique Words**: A `Set` of all unique words found in the file.

The class is designed to be used for sorting and comparison, with all necessary methods implemented. Here's a brief overview of the constructor:

```java
public Book(Path file) throws IOException {
    List<String> lines = Files.readAllLines(file);
    this.name = lines.isEmpty() ? "(no title)" : lines.get(0);
    this.lineCount = lines.size();

    for (String line : lines) {
        String[] words = line.toLowerCase().split("\\W+");
        uniqueWords.addAll(Arrays.asList(words));
    }
}

## B) Natural Order – Alphabetical by Book Name

I used the `Comparable` interface to implement the natural ordering of books alphabetically by their name (title). Then I sorted the list like this:

```java
Collections.sort(bookList); // Uses compareTo()

## C) Order by Line Count – Ascending

To sort books by the number of lines (from smallest to largest), I used a comparator:

```java
bookList.sort(Comparator.comparingInt(Book::getLineCount));

## D) Order by Unique Word Count – Descending

For more advanced sorting, I counted the number of unique words using a `Set<String>`. To sort in descending order (largest vocabulary first), I used:

```java
bookList.sort(Comparator.comparingInt(Book::getUniqueWordCount).reversed());


