package s2;

public class ProductInventoryCSVParser {

    public void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + fields[0]
                    + " | SKU: " + fields[1]
                    + " | Qty: " + fields[2]);
        }
    }

    public static void main(String[] args) {
        ProductInventoryCSVParser obj = new ProductInventoryCSVParser();

        obj.parseInventoryRecord("Wireless Mouse,WM-250,520");
        obj.parseInventoryRecord("Wireless Mouse,150");
    }
}