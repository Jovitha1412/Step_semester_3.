package Assignment_Problems;

public class SkipMultiplesPrinter {

    public static void main(String[] args) {
        printSkippingMultiplesOfThree();
    }

    static void printSkippingMultiplesOfThree() {

        for (int i = 1; i <= 20; i++) {

            if (i % 3 == 0) {
                continue;
            }

            System.out.print(i + " ");
        }
    }
}