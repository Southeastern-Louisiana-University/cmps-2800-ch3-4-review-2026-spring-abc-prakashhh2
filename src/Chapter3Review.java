import java.util.Scanner;

public class Chapter3Review {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- 1. INPUT & SANITIZATION ---
        System.out.print("Enter the code: ");
        String raw = input.nextLine().trim();

        // --- 2. STRING EXTRACTION ---
        int firstDash = raw.indexOf('-');
        int secondDash = raw.lastIndexOf('-');

        if (firstDash == -1 || secondDash == -1 || firstDash == secondDash) {
            System.out.println("Invalid format. Expected: prefix-ID-suffix");
            return;
        }

        String prefix = raw.substring(0, firstDash);
        String idStr = raw.substring(firstDash + 1, secondDash);
        String suffix = raw.substring(secondDash + 1);

        // --- 3. CHARACTER ANALYSIS ---
        char firstChar = prefix.charAt(0);

        if (!Character.isLetter(firstChar)) {
            System.out.println("Prefix must start with a letter.");
            return;
        }

        char upperChar = Character.toUpperCase(firstChar);

        // --- 4. MATHEMATICAL CALCULATION ---
        int id = Integer.parseInt(idStr);
        double result = Math.sqrt(Math.pow(id, 3));

        // --- 5. FORMATTED OUTPUT ---
        System.out.println("\nRESULT");
        System.out.printf("%-10s %-10d %-10.3f%n",
                String.valueOf(upperChar),
                id,
                result);

        input.close();
    }
}
