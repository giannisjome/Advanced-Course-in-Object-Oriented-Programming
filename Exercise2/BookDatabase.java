import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDatabase {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<ReadOnlyBook> searchBooksForCustomer(String query) {
        return books.stream()
                .filter(b -> b.getTitle().contains(query))
                .map(b -> (ReadOnlyBook) b)
                .collect(Collectors.toList());
    }

    public Book findBookForStaff(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}
