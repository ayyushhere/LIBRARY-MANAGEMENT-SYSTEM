import java.util.Scanner;

public class Executer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        // Add some default books
        lib.addBook("The Alchemist", "Paulo Coelho");
        lib.addBook("Clean Code", "Robert C. Martin");
        lib.addBook("DSA in Java", "CipherSchools");

        while (true) {
            System.out.println("\n*** Library Menu ***");
            System.out.println("1. Show Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show Borrowed Books");
            System.out.println("5. Add New Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    lib.displayBooks();
                    break;
                case 2:
                    lib.displayBooks();
                    System.out.print("Enter book number to borrow: ");
                    int bIndex = sc.nextInt() - 1;
                    if (lib.borrowBook(bIndex)) {
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Book cannot be issued.");
                    }
                    break;
                case 3:
                    lib.showBorrowedBooks();
                    System.out.print("Enter book number to return: ");
                    int rIndex = sc.nextInt() - 1;
                    lib.returnBook(rIndex);
                    System.out.println("Book returned successfully.");
                    break;
                case 4:
                    lib.showBorrowedBooks();
                    break;
                case 5:
                    System.out.print("Enter book name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    lib.addBook(name, author);
                    System.out.println("Book added successfully.");
                    break;
                case 0:
                    System.out.println("Exiting Library System. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
