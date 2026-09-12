package Assignment_Problems.s6;

public class libraryinventory {

    String title;
    String author;
    int copiesAvailable;

    // Constructor
    libraryinventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Method
    void printEntry() {
        System.out.println(title + " by " + author + " - "
                + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {

        libraryinventory b1 =
                new libraryinventory("Clean Code", "Robert C. Martin", 3);

        libraryinventory b2 =
                new libraryinventory("Effective Java", "Joshua Bloch", 5);

        libraryinventory b3 =
                new libraryinventory("Refactoring", "Martin Fowler", 0);

        libraryinventory b4 =
                new libraryinventory("Design Patterns", "GoF", 2);

        libraryinventory[] books = {b1, b2, b3, b4};

        for (libraryinventory book : books) {
            book.printEntry();
        }
    }
}