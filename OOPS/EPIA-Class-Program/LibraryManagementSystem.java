import java.util.*;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved: " + getTitle());
        } else {
            System.out.println("Book not available: " + getTitle());
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved: " + getTitle());
        } else {
            System.out.println("Magazine not available: " + getTitle());
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved: " + getTitle());
        } else {
            System.out.println("DVD not available: " + getTitle());
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B1", "Java Programming", "John Doe"));
        items.add(new Magazine("M1", "Tech Monthly", "Jane Smith"));
        items.add(new DVD("D1", "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Available: " + reservable.checkAvailability());
                reservable.reserveItem();
                System.out.println("Available after reservation: " + reservable.checkAvailability());
            }
            System.out.println();
        }
    }
}
