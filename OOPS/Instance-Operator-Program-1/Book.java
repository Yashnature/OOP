import java.util.*;

public class Book {
    private static String libraryName = "City Central Library";

    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public String getIsbn() {
        if (this instanceof Book) {
            return this.isbn;
        }
        return null;
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    public static void main(String[] args) {
        Book.displayLibraryName();

        Book b1 = new Book("1984", "George Orwell", "ISBN001");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN002");

        b1.displayDetails();
        b2.displayDetails();

        System.out.println("Book 1 ISBN: " + b1.getIsbn());
    }
}
