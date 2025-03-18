package task2.PalindromeChecker;

import java.util.Scanner;

public class PalindromeChecker {
	public static boolean isPalindrome(String input) {
		String inputStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int start = 0;
		int end = inputStr.length() - 1;
		do {
			if (inputStr.charAt(start) != inputStr.charAt(end)) {
				return false;
			}
			start++;
			end--;
		} while (start < end);
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a word or phrase: ");
		String input = sc.nextLine();

		if (input.length() < 2) {
			System.out.println("Please enter word with length more than two ");
			sc.close();
			return;
		}
		if (isPalindrome(input)) {
			System.out.println("Entered word or phrase is a palindrome");
		} else {
			System.out.println("Entered word or phrase is not a palindrome");
		}
		sc.close();
	}
}