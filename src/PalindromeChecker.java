public class PalindromeChecker {
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        String reversed = reverseString(input);
        return input.equals(reversed);
    }
    public static void main(String[] args) {
        String test = "madam";

        System.out.println("Original:" + test);
        System.out.println("Reveresed:" + reverseString(test));

        if (isPalindrome(test)) {
            System.out.println ("Its Palindrome");
        } else {
            System.out.println("Its nor a palindrome");
        }
    }
}
