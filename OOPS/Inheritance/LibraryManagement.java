import java.util.*;  

class Book {
    String title;
    int publicationYear;

    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author a = new Author();
        a.title = "Java Programming";
        a.publicationYear = 2023;
        a.name = "John Doe";
        a.bio = "Experienced Java developer and author.";

        a.displayInfo();
    }
}
