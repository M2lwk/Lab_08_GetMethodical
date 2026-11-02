// DevTest.java - Development testing file for SafeInput methods
import java.util.Scanner;

public class DevTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== SafeInput Library Development Tests ===\n");

        // Test getNonZeroLenString
        System.out.println("--- Testing getNonZeroLenString ---");
        String name = SafeInput.getNonZeroLenString(in, "Enter your name");
        System.out.println("You entered: " + name);

        // Test getInt
        System.out.println("\n--- Testing getInt ---");
        int anyInt = SafeInput.getInt(in, "Enter any integer");
        System.out.println("You entered: " + anyInt);

        // Test getDouble
        System.out.println("\n--- Testing getDouble ---");
        double anyDouble = SafeInput.getDouble(in, "Enter any double");
        System.out.println("You entered: " + anyDouble);

        // Test getRangedInt
        System.out.println("\n--- Testing getRangedInt ---");
        int rangedInt = SafeInput.getRangedInt(in, "Enter a number", 1, 10);
        System.out.println("You entered: " + rangedInt);

        // Test getRangedDouble
        System.out.println("\n--- Testing getRangedDouble ---");
        double rangedDouble = SafeInput.getRangedDouble(in, "Enter a price", 0.50, 10.00);
        System.out.println("You entered: " + rangedDouble);

        // Test getYNConfirm
        System.out.println("\n--- Testing getYNConfirm ---");
        boolean confirm = SafeInput.getYNConfirm(in, "Do you want to continue");
        System.out.println("You chose: " + (confirm ? "Yes" : "No"));

        // Test getRegExString
        System.out.println("\n--- Testing getRegExString (SSN pattern) ---");
        String ssn = SafeInput.getRegExString(in, "Enter SSN (###-##-####)", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("Valid SSN: " + ssn);

        // Test prettyHeader
        System.out.println("\n--- Testing prettyHeader ---");
        SafeInput.prettyHeader("Message Centered Here");

        in.close();
    }
}