public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker Management System";
    private static final String APP_VERSION = "1.0";

    public static void main(String[] args) {
        displayWelcomeMessage();

        checkHardcodedPalindrome();

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
}