import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Application constants
    private static final String APP_NAME = "Palindrome Checker Management System";
    private static final String APP_VERSION = "1.0";

    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        displayWelcomeMessage();

        // UC2: Print a Hardcoded Palindrome Result
        checkHardcodedPalindrome();

        // UC3: Palindrome Check Using String Reverse
        checkPalindromeUsingReverse();

        // UC4: Character Array Based Palindrome Check
        checkPalindromeUsingCharArray();

        // UC5: Stack-Based Palindrome Checker
        checkPalindromeUsingStack();

        // UC6: Queue + Stack Based Palindrome Check
        checkPalindromeUsingQueueAndStack();

        // UC7: Deque-Based Optimized Palindrome Checker
        checkPalindromeUsingDeque();

        // UC8: Linked List Based Palindrome Checker
        checkPalindromeUsingLinkedList();

        // UC9: Recursive Palindrome Checker
        checkPalindromeUsingRecursion();

        // UC10: Case-Insensitive & Space-Ignored Palindrome
        checkPalindromeWithNormalization();

        // UC11: Object-Oriented Palindrome Service
        checkPalindromeUsingService();

        // UC12: Strategy Pattern for Palindrome Algorithms
        checkPalindromeUsingStrategy();

        // UC13: Performance Comparison
        comparePerformance();

        // Program continues to next use case or exits
        System.out.println("System initialized successfully.");
    }

    // UC1: Displays the welcome message with application name and version
    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the " + APP_NAME);
        System.out.println("Version : " + APP_VERSION);
    }

    // UC2: Check and display result for a hardcoded palindrome string
    private static void checkHardcodedPalindrome() {
        String input = "madam";
        boolean result = isPalindrome(input);
        System.out.println("Input text: " + input);
        System.out.println("Is it a palindrome? : " + result);
    }

    // Checks if a given string is a palindrome
    private static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // UC3: Check palindrome by reversing the string
    private static void checkPalindromeUsingReverse() {
        String input = "madam";
        boolean result = isPalindromeByReverse(input);
        System.out.println("Input text: " + input);
        System.out.println("Reversed text: " + reverseString(input));
        System.out.println("Is it a palindrome? : " + result);
    }

    // Reverses a string using a loop
    private static String reverseString(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        return reversed;
    }

    // Checks if a string is a palindrome by comparing with its reverse
    private static boolean isPalindromeByReverse(String input) {
        String reversed = reverseString(input);
        return input.equals(reversed);
    }

    // UC4: Check palindrome using character array and two-pointer technique
    private static void checkPalindromeUsingCharArray() {
        String input = "radar";
        boolean result = isPalindromeUsingCharArray(input);
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? : " + result);
    }

    // Checks if a string is a palindrome using char array and two-pointer approach
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

    // UC5: Check palindrome using Stack data structure
    private static void checkPalindromeUsingStack() {
        String input = "noon";
        boolean result = isPalindromeUsingStack(input);
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? : " + result);
    }

    // Checks if a string is a palindrome using Stack (LIFO principle)
    private static boolean isPalindromeUsingStack(String input) {
        Stack<Character> stack = new Stack<>();

        // Push all characters into the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;

        // Pop characters and compare with original
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    // UC6: Check palindrome using Queue (FIFO) and Stack (LIFO)
    private static void checkPalindromeUsingQueueAndStack() {
        String input = "civic";
        boolean result = isPalindromeUsingQueueAndStack(input);
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? : " + result);
    }

    // Checks if a string is a palindrome by comparing Queue (FIFO) vs Stack (LIFO)
    private static boolean isPalindromeUsingQueueAndStack(String input) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue to queue and push to stack
        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        // Dequeue from queue (FIFO) and pop from stack (LIFO) and compare
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    // UC7: Check palindrome using Deque (Double Ended Queue)
    private static void checkPalindromeUsingDeque() {
        String input = "refer";
        boolean result = isPalindromeUsingDeque(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }

    // Checks if a string is a palindrome using Deque front and rear access
    private static boolean isPalindromeUsingDeque(String input) {
        // Create a Deque to store characters
        Deque<Character> deque = new ArrayDeque<>();

        // Add each character to the deque
        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        // Flag to track palindrome result
        boolean isPalindrome = true;

        // Continue comparison while more than one element exists
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    // UC8: Check palindrome using Linked List data structure
    private static void checkPalindromeUsingLinkedList() {
        String input = "level";
        boolean result = isPalindromeUsingLinkedList(input);
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? : " + result);
    }

    // Checks if a string is a palindrome using LinkedList
    // Compares characters from both ends by removing from front and back
    private static boolean isPalindromeUsingLinkedList(String input) {
        // Create a LinkedList to store characters
        LinkedList<Character> list = new LinkedList<>();

        // Add each character to the linked list
        for (char c : input.toCharArray()) {
            list.add(c);
        }

        // Flag to track palindrome result
        boolean isPalindrome = true;

        // Continue comparison while more than one element exists
        while (list.size() > 1) {
            // Remove and compare first and last characters
            if (list.removeFirst() != list.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    // UC9: Check palindrome using Recursion
    private static void checkPalindromeUsingRecursion() {
        String input = "madam";
        boolean result = isPalindromeUsingRecursion(input);
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? : " + result);
    }

    // Checks if a string is a palindrome using recursion
    private static boolean isPalindromeUsingRecursion(String input) {
        return isPalindromeRecursive(input, 0, input.length() - 1);
    }

    // Recursive method to check palindrome by comparing characters from both ends
    private static boolean isPalindromeRecursive(String input, int start, int end) {
        // Base condition: If start crosses or meets end, it's a palindrome
        if (start >= end) {
            return true;
        }

        // Compare characters at start and end positions
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        // Recursive call: Move to next inner pair of characters
        return isPalindromeRecursive(input, start + 1, end - 1);
    }

    // UC10: Check palindrome ignoring spaces and case
    private static void checkPalindromeWithNormalization() {
        String input = "A man a plan a canal Panama";
        boolean result = isPalindromeWithNormalization(input);
        System.out.println("Input: " + input);
        System.out.println("Is palindrome? : " + result);
    }

    // Checks if a string is a palindrome after normalizing (removing spaces and
    // converting to lowercase)
    private static boolean isPalindromeWithNormalization(String input) {
        // Normalize: Remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Check palindrome using two-pointer approach
        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // UC11: Object-oriented service check helper
    private static void checkPalindromeUsingService() {
        String input = "racecar";
        boolean result = palindromeCheckerService(input);
        System.out.println("Input: " + input);
        System.out.println("Is palindrome (service)? : " + result);
    }

    // UC11: Encapsulated palindrome service method
    // Demonstrates encapsulation and single responsibility principle
    private static boolean palindromeCheckerService(String text) {
        if (text == null) return false;
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // UC12: Strategy Pattern for Palindrome Algorithms
    private static void checkPalindromeUsingStrategy() {
        String input = "level";
        
        // Using StackStrategy
        boolean resultStack = checkUsingStackStrategy(input);
        System.out.println("Input: " + input);
        System.out.println("Is palindrome (StackStrategy)? : " + resultStack);
        
        // Using DequeStrategy
        boolean resultDeque = checkUsingDequeStrategy(input);
        System.out.println("Is palindrome (DequeStrategy)? : " + resultDeque);
    }

    // UC12: Stack-Based Strategy Implementation
    private static boolean checkUsingStackStrategy(String input) {
        if (input == null) return false;
        Stack<Character> stack = new Stack<>();
        
        // Push each character of the input string into the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        
        // Compare characters by popping from the stack
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // UC12: Deque-Based Strategy Implementation
    private static boolean checkUsingDequeStrategy(String input) {
        if (input == null) return false;
        Deque<Character> deque = new ArrayDeque<>();
        
        // Add each character to the deque
        for (char c : input.toCharArray()) {
            deque.add(c);
        }
        
        // Compare characters from both ends
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    // UC13: Performance Comparison of different palindrome algorithms
    private static void comparePerformance() {
        String input = "level";
        
        System.out.println("Input: " + input);
        
        // Test Stack Strategy
        long startStack = System.nanoTime();
        boolean resultStack = checkUsingStackStrategy(input);
        long endStack = System.nanoTime();
        long timeStack = endStack - startStack;
        System.out.println("StackStrategy - Is Palindrome?: " + resultStack + " | Execution Time: " + timeStack + " ns");
        
        // Test Deque Strategy
        long startDeque = System.nanoTime();
        boolean resultDeque = checkUsingDequeStrategy(input);
        long endDeque = System.nanoTime();
        long timeDeque = endDeque - startDeque;
        System.out.println("DequeStrategy - Is Palindrome?: " + resultDeque + " | Execution Time: " + timeDeque + " ns");
        
        // Test Two-Pointer Strategy
        long startTwoPointer = System.nanoTime();
        boolean resultTwoPointer = isPalindromeUsingCharArray(input);
        long endTwoPointer = System.nanoTime();
        long timeTwoPointer = endTwoPointer - startTwoPointer;
        System.out.println("TwoPointerStrategy - Is Palindrome?: " + resultTwoPointer + " | Execution Time: " + timeTwoPointer + " ns");
        
        // Determine fastest
        long minTime = Math.min(timeStack, Math.min(timeDeque, timeTwoPointer));
        if (minTime == timeStack) {
            System.out.println("Fastest: StackStrategy");
        } else if (minTime == timeDeque) {
            System.out.println("Fastest: DequeStrategy");
        } else {
            System.out.println("Fastest: TwoPointerStrategy");
        }
    }
}