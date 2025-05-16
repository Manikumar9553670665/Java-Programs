public class PrimeNumberGenerator {
    public static void main(String[] args) {
        System.out.println("Prime numbers between 1 and 100 are:");

        for (int number = 2; number <= 100; number++) {
            boolean isPrime = true;

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(number + " ");
            }
        }
    }
}
