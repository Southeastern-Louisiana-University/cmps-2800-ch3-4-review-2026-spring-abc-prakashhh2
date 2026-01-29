import java.util.Scanner;

public class Gatekeeper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- 1. INPUTS ---
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Security Code: ");
        int code = sc.nextInt();

        System.out.print("Enter Clearance Level (1-3): ");
        int level = sc.nextInt();


        // --- 2. BOOLEAN PRE-CHECKS (Chapter 3.10) ---

        // Rule: Age must be between 18 and 65 inclusive
        boolean isValidAge = age >= 18 && age <= 65;


        // Rule: (Divisible by 5 OR 7) AND (NOT divisible by 10)
        // We use parentheses to ensure the OR happens before the AND
        boolean isValidCode = (code % 5 == 0 || code % 7 == 0) && code % 10 != 0;


        // Rule: Level must be 1, 2, or 3. If not, they are blocked.
        boolean isBlocked = !(level == 1 || level == 2 || level == 3);

        // --- 3. CONTROL FLOW DECISIONS (Chapter 3.3 & 3.13) ---

        // Priority 1: Check if the level is totally invalid
        if (isBlocked) {
            System.out.println(" ACCESS DENIED: Invalid Level");

        } else if (!isValidAge) {
            System.out.println("ACCESS DENIED: Age Restriction");

        } else {
            if (!isValidCode) {
                System.out.println("ACCESS DENIED: Invalid Code");
            } else {
                switch (level) {
                    case 1:
                        System.out.println("Guest Access Granted");
                        break;
                    case 2:
                        System.out.println("User Access Granted");
                    case 3:
                        System.out.println("Admin Access Granted");
                        break;
                }
            }
        }


        // --- 4. RISK ASSESSMENT (Ternary Operator - Chapter 3.14) ---
        // Syntax: (condition) ? value_if_true : value_if_false
        String risk = (age < 25 || code > 1000) ? "High Risk" : "Low Risk";
        System.out.println("Risk Assessment: " + risk);

        sc.close();









    }
}