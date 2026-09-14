package classproblem.s6;

class IdCard {
    String name;
    int booksIssued;

    // Constructor
    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        // First object
        IdCard ravi = new IdCard("Ravi", 0);

        // Second variable pointing to the SAME object
        IdCard duplicate = ravi;

        // Change through second variable
        duplicate.booksIssued = 3;

        // Print through first variable
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);

        // Compare references
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Third SEPARATE object
        IdCard separate = new IdCard("Ravi", 3);

        // Compare with first object
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}