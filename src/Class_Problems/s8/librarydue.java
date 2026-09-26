
package Class_Problems.s8;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

public class librarydue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Function<String, LibraryItem>> items = new HashMap<>();
        items.put("BOOK", Book::new);
        items.put("DVD", DVD::new);
        items.put("MAGAZINE", Magazine::new);

        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');

            String type = line.substring(0, space).toUpperCase();
            String title = line.substring(space + 1).trim();

            // Remove quotation marks if present
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item = items.get(type).apply(title);
            LocalDate dueDate = item.calculateDueDate(currentDate);

            System.out.println(item.title + ": " + dueDate);
        }

        sc.close();
    }

    static abstract class LibraryItem {
        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getBorrowingDays();

        LocalDate calculateDueDate(LocalDate currentDate) {
            return currentDate.plusDays(getBorrowingDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        int getBorrowingDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title) {
            super(title);
        }

        int getBorrowingDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        int getBorrowingDays() {
            return 3;
        }
    }
}
