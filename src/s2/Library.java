package s2;

public class Library {

    public String normalizeCode(String raw) {
        raw = raw.trim();

        String publisher = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return publisher + rest;
    }

    public String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Build formatted output
        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(publisher)
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        Library obj =
                new Library();

        String raw = " pen2007141207 ";

        String code = obj.normalizeCode(raw);

        System.out.println(obj.validateAndFormat(code));
    }
}