package Assignment_Problems.s2;

import java.util.Scanner;

public class ProductInventory {

    public static void parseInventoryRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length == 3) {
            System.out.println("Product: " + fields[0]
                    + " | SKU: " + fields[1]
                    + " | Qty: " + fields[2]);
        } else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter CSV record:");
        String csvLine = sc.nextLine();

        parseInventoryRecord(csvLine);

        sc.close();
    }
}