import java.util.Scanner;

public class LoanChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take inputs
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your monthly income: ");
        double income = scanner.nextDouble();

        System.out.print("Enter your credit score: ");
        int creditScore = scanner.nextInt();

        // Step 2: Use nested if to determine eligibility
        if (age >= 21 && age <= 65) {
            if (income >= 3000) {
                if (creditScore >= 700) {
                    System.out.println("You are eligible for the loan.");
                } else if (creditScore >= 600) {
                    System.out.println("You are partially eligible for the loan.");
                } else {
                    System.out.println("You are not eligible due to low credit score.");
                }
            } else {
                System.out.println("You are not eligible due to low income.");
            }
        } else {
            System.out.println("You are not eligible due to age restrictions.");
        }

        scanner.close();
    }
}

