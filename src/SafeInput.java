// SafeInput.java - The complete input validation library
import java.util.Scanner;

/**
 * SafeInput - A library of static methods for safe user input validation
 * This library provides bulletproof input methods for various data types
 */
public class SafeInput {

    /**
     * Gets a non-zero length string from the user
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    /**
     * Gets an integer from the user with validation
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a valid integer
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retValue = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                valid = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash + ". Please enter a valid integer.");
            }
            pipe.nextLine(); // clear the newline
        } while (!valid);
        return retValue;
    }

    /**
     * Gets a double from the user with validation
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a valid double
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retValue = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                valid = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash + ". Please enter a valid number.");
            }
            pipe.nextLine(); // clear the newline
        } while (!valid);
        return retValue;
    }

    /**
     * Gets an integer within a specified range from the user
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low the low value for the input range (inclusive)
     * @param high the high value for the input range (inclusive)
     * @return a valid integer within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retValue = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                if (retValue >= low && retValue <= high) {
                    valid = true;
                } else {
                    System.out.println("Input out of range. Please enter a value between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash + ". Please enter a valid integer.");
            }
            pipe.nextLine(); // clear the newline
        } while (!valid);
        return retValue;
    }

    /**
     * Gets a double within a specified range from the user
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low the low value for the input range (inclusive)
     * @param high the high value for the input range (inclusive)
     * @return a valid double within the range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retValue = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                if (retValue >= low && retValue <= high) {
                    valid = true;
                } else {
                    System.out.println("Input out of range. Please enter a value between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash + ". Please enter a valid number.");
            }
            pipe.nextLine(); // clear the newline
        } while (!valid);
        return retValue;
    }

    /**
     * Gets a Yes/No confirmation from the user
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return true for yes (Y/y), false for no (N/n)
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean valid = false;
        boolean result = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.length() == 1) {
                char choice = response.charAt(0);
                if (choice == 'Y' || choice == 'y') {
                    result = true;
                    valid = true;
                } else if (choice == 'N' || choice == 'n') {
                    result = false;
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please enter Y or N.");
                }
            } else {
                System.out.println("Invalid input. Please enter a single character Y or N.");
            }
        } while (!valid);
        return result;
    }

    /**
     * Gets a string that matches a specified RegEx pattern
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regEx the RegEx pattern to match
     * @return a valid string matching the pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retString = "";
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
            if (retString.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Invalid input format. Please match the pattern: " + regEx);
            }
        } while (!valid);
        return retString;
    }

    /**
     * Creates a pretty header with a centered message
     * @param msg the message to display in the header
     */
    public static void prettyHeader(String msg) {
        final int WIDTH = 60;
        final int STARS_PER_SIDE = 3;
        final int AVAILABLE_SPACE = WIDTH - (STARS_PER_SIDE * 2);

        // Top line of stars
        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Middle line with centered message
        int msgLength = msg.length();
        int padding = (AVAILABLE_SPACE - msgLength) / 2;

        // Print left stars
        for (int i = 0; i < STARS_PER_SIDE; i++) {
            System.out.print("*");
        }

        // Print left padding spaces
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }

        // Print the message
        System.out.print(msg);

        // Print right padding spaces (account for odd length messages)
        int rightPadding = AVAILABLE_SPACE - padding - msgLength;
        for (int i = 0; i < rightPadding; i++) {
            System.out.print(" ");
        }

        // Print right stars
        for (int i = 0; i < STARS_PER_SIDE; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Bottom line of stars
        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}