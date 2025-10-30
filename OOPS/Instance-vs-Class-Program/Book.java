import java.util.*;

public class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("978-1234567890", "Java Basics", "John Doe", 1.2);
        System.out.println("EBook Details:");
        System.out.println("ISBN: " + ebook.ISBN);
        System.out.println("Title: " + ebook.title);
        System.out.println("Author: " + ebook.getAuthor());
        System.out.println("File Size: " + ebook.fileSize + " MB");

        ebook.setAuthor("Jane Smith");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}

class EBook extends Book {
    public double fileSize;

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }
}
