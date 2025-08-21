import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add a book
    public boolean addBook(String name, String author) {
        try {
            books.add(new Book(name, author));
            return true;
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
            return false;
        }
    }

    // Show all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    // Show only borrowed books
    public void showBorrowedBooks() {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBorrowed()) {
                System.out.println((i + 1) + ". " + books.get(i).getBookName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No borrowed books currently.");
        }
    }

    // Borrow a book
    public boolean borrowBook(int index) {
        if (index < 0 || index >= books.size()) {
            return false;
        }
        if (books.get(index).isBorrowed()) return false;

        books.get(index).setBorrowedStatus(true);
        return true;
    }

    // Return a book
    public void returnBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.get(index).setBorrowedStatus(false);
        }
    }
}
