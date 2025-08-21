public class Book {
    private String name;
    private String author;
    private boolean isBorrowed;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getBookName() {
        return this.name;
    }

    public String getAuthorName() {
        return this.author;
    }

    public boolean isBorrowed() {
        return this.isBorrowed;
    }

    public void setBorrowedStatus(boolean flag) {
        this.isBorrowed = flag;
    }

    @Override
    public String toString() {
        return "\"" + name + "\" by " + author + (isBorrowed ? " (Borrowed)" : " (Available)");
    }
}
