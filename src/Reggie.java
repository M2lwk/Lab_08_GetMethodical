import java.util.Scanner;
public class Reggie {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String ssn = SafeInput.getRegExString(in, "Enter SSN (###-##-####)", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("Valid SSN: " + ssn);
        String mNumber = SafeInput.getRegExString(in, "Enter M number", "^(M|m)\\d{5}$");
        System.out.println("Valid M number: " + mNumber);
        String choice = SafeInput.getRegExString(in, "Enter choice [O/S/V/Q]", "^[OoSsVvQq]$");
        System.out.println("Valid choice: " + choice);
    }
}