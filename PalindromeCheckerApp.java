import java.util.Stack;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker Management System";
    private static final String APP_VERSION = "1.0";

    public static void main(String[] args) {
        displayWelcomeMessage();

        checkHardcodedPalindrome();

        checkPalindromeUsingReverse();

        checkPalindromeUsingCharArray();

        checkPalindromeUsingStack();

        System.out.println("System initialized successfully.");
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the " + APP_NAME);
        System.out.println("Version : " + APP_VERSION);
    }

    private static void checkHardcodedPalindrome() {
        String input = "madam";
        boolean result = isPalindrome(input);
        System.out.println("Input text: " + input);
        System.out.println("Is it a palindrome? : " + result);
    }

    private static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static void checkPalindromeUsingReverse() {
        String input = "madam";
        boolean result = isPalindromeByReverse(input);
        System.out.println("Input text: " + input);
        System.out.println("Reversed text: " + reverseString(input));
        System.out.println("Is it a palindrome? : " + result);
    }

    private static String reverseString(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        return reversed;
    }

    private static boolean isPalindromeByReverse(String input) {
        String reversed = reverseString(input);
        return input.equals(reversed);
    }

    private static void checkPalindromeUsingCharArray() {
        String input = "radar";
        boolean result = isPalindromeUsingCharArray(input);
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? : " + result);
    }

    private static boolean isPalindromeUsingCharArray(String input) {
        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        return isPalindrome;
    }

    private static void checkPalindromeUsingStack() {
        String input = "noon";
        boolean result = isPalindromeUsingStack(input);
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? : " + result);
    }

    private static boolean isPalindromeUsingStack(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}