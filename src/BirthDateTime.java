import java.util.Scanner;

public class BirthDateTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int year = SafeInput.getRangedInt(in, "Enter your birth year", 1950, 2015);
        int month = SafeInput.getRangedInt(in, "Enter your birth month", 1, 12);

        int dayLimit = 31;
        switch (month) {
            case 2:
                dayLimit = 29;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayLimit = 30;
                break;
            default:
                dayLimit = 31;
                break;
        }

        int day = SafeInput.getRangedInt(in, "Enter your birth day", 1, dayLimit);
        int hours = SafeInput.getRangedInt(in, "Enter your birth hour", 1, 24);
        int minutes = SafeInput.getRangedInt(in, "Enter your birth minute", 1, 59);

        System.out.println("\nYour birth date and time is: " + month + "/" + day + "/" + year + " at " + hours + ":" + minutes);
    }
}
