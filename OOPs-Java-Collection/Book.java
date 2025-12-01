import java.util.*;

class Book {
    String id;
    String title;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return id + " - " + title;
    }
}

public class LibrarySystem {
    List<Book> totalBooks = new ArrayList<>();
    Set<String> memberIds = new HashSet<>();
    Queue<Book> issueQueue = new LinkedList<>();
    Stack<Book> returnedBooks = new Stack<>();

    public void addBook(Book b) {
        totalBooks.add(b);
    }

    public boolean registerMember(String memberId) {
        return memberIds.add(memberId);
    }

    public void requestBook(Book b) {
        if (totalBooks.contains(b)) issueQueue.add(b);
    }

    public void issueBook() {
        if (!issueQueue.isEmpty()) {
            Book b = issueQueue.poll();
            System.out.println("Issued: " + b);
        }
    }

    public void returnBook(Book b) {
        if (totalBooks.contains(b)) {
            returnedBooks.push(b);
            System.out.println("Returned: " + b);
        }
    }

    public void reissueLastReturned() {
        if (!returnedBooks.isEmpty()) {
            Book b = returnedBooks.pop();
            System.out.println("Re-issued: " + b);
        }
    }

    public void showBooks() {
        System.out.println("=== All Books ===");
        for (Book b : totalBooks) System.out.println(b);
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        Book b1 = new Book("B001", "Java Programming");
        Book b2 = new Book("B002", "Data Structures");
        Book b3 = new Book("B003", "Algorithms");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        library.registerMember("M001");
        library.registerMember("M002");

        library.requestBook(b1);
        library.requestBook(b2);

        library.issueBook();
        library.returnBook(b1);
        library.reissueLastReturned();

        library.showBooks();
    }
}
