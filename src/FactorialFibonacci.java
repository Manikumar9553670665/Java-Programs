import java.util.Scanner;
public class FactorialFibonacci {
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;

        }
        return result;
    }

    public static void fibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + (i < n - 1 ? ", " : ""));
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("Factorial of " + number + ": " + factorial(number));
        fibonacci(number);

        scanner.close();
    }
}
