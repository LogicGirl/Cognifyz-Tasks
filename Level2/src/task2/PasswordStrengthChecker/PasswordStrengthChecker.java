package task2.PasswordStrengthChecker;

import java.util.Scanner;

public class PasswordStrengthChecker {

	public static String checkPasswordStrength(String password) {
		int len = password.length();
		boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

		for (char ch : password.toCharArray()) {
			if (Character.isUpperCase(ch))
				hasUpper = true;
			else if (Character.isLowerCase(ch))
				hasLower = true;
			else if (Character.isDigit(ch))
				hasDigit = true;
			else
				hasSpecial = true;
		}

		if (len < 6) {
			return "too weak";
		} else if (len < 8) {
			return (hasUpper || hasLower) && hasDigit ? "moderate" : "weak";
		} else {
			return (hasUpper && hasLower && hasDigit && hasSpecial) ? "strong" : "moderate";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a password: ");
		String password = sc.nextLine();

		String strength = checkPasswordStrength(password);
		System.out.println("Password strength is " + strength);

		sc.close();
	}
}