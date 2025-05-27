import java.util.Scanner;


class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionDemo {

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to register.");
        } else {
            System.out.println("Age is valid. Registration successful.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        try {
            System.out.print("Enter a number to divide 100 by: ");
            int num = scanner.nextInt();
            int result = 100 / num;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }


        try {
            String text = null;
            System.out.println("Length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Error: Attempted to access null object.");
        }


        try {
            int[] arr = {1, 2, 3};
            System.out.println("Element at index 5: " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds.");
        }


        try {
            System.out.print("Enter your age for registration: ");
            int age = scanner.nextInt();
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }

        scanner.close();
    }
}

