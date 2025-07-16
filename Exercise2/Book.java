public class Book implements ReadOnlyBook {
    private String title;
    private int publicationYear;
    private String publisher;
    private boolean isLost;

    public Book(String title, int publicationYear, String publisher) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.isLost = false;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void markAsLost() {
        this.isLost = true;
    }
}
