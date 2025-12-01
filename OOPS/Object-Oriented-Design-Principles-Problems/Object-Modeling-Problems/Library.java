import java.util.*;

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        class Book {
            String title;
            String author;

            Book(String title, String author) {
                this.title = title;
                this.author = author;
            }
        }

        Library l1 = new Library();
        Library l2 = new Library();

        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b4 = new Book("Pride and Prejudice", "Jane Austen");

        l1.books.add(b1);
        l1.books.add(b2);
        l2.books.add(b2);
        l2.books.add(b3);
        l2.books.add(b4);

        System.out.println("Library 1 books:");
        for (Book b : l1.books) {
            System.out.println(b.title + " by " + b.author);
        }

        System.out.println("Library 2 books:");
        for (Book b : l2.books) {
            System.out.println(b.title + " by " + b.author);
        }
    }
}
