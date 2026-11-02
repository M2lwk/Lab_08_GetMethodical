import java.util.Scanner;
public class BirthDateTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = SafeInput.getRangedInt(in, "Enter your birth year", 1950, 2015);
        int month = SafeInput.getRangedInt(in, "Enter your birth month", 1, 12);
        int maxDays;
        switch (month)
        {
            case 2: maxDays = 29; break;
            case 4: case 6: case 9: case 11: maxDays = 30; break;
            default: maxDays = 31; break;
        }
        int day = SafeInput.getRangedInt(in, "Enter your birth day", 1, maxDays);
        int hours = SafeInput.getRangedInt(in, "Enter your birth hour", 1, 24);
        int minutes = SafeInput.getRangedInt(in, "Enter your birth minute", 1, 59);
        System.out.println("\nDate: " + month + "/" + day + "/" + year);
        System.out.println("Time: " + hours + ":" + String.format("%02d", minutes));
    }
}