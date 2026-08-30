package s2;

public class ATMPINLengthValidator {

    public void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        ATMPINLengthValidator obj = new ATMPINLengthValidator();

        obj.checkPinLength("600");
        obj.checkPinLength("1421");
    }
}