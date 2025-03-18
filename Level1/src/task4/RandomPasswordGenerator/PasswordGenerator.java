package task4.RandomPasswordGenerator;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

	public static boolean[] characterTypes(Scanner sc) {
		boolean[] cht = new boolean[4];
		cht[0] = userChoice(sc, "numbers");
		cht[1] = userChoice(sc, "lowercase letters");
		cht[2] = userChoice(sc, "uppercase letters");
		cht[3] = userChoice(sc, "special characters");
		return cht;
	}

	public static boolean userChoice(Scanner sc, String charType) {
		System.out.print("Include " + charType + "? (Yes/No): ");
		String response = sc.next();
		return response.equalsIgnoreCase("Yes");
	}

	public static String generatePassword(int length, boolean[] charTypes) {
		String numbers = "0123456789";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String specialChars = "!@#$%^&*()_+[]{}|;:,.<>?";

		Random random = new Random();
		StringBuilder password = new StringBuilder();
		int count = 1;
		while (count <= length) {
			if (charTypes[0] && count <= length) {
				int index = random.nextInt(numbers.length());
				password.append(numbers.charAt(index));
				count++;
			}
			if (charTypes[1] && count <= length) {
				int index = random.nextInt(lowercase.length());
				password.append(lowercase.charAt(index));
				count++;
			}
			if (charTypes[2] && count <= length) {
				int index = random.nextInt(uppercase.length());
				password.append(uppercase.charAt(index));
				count++;
			}
			if (charTypes[3] && count <= length) {
				int index = random.nextInt(specialChars.length());
				password.append(specialChars.charAt(index));
				count++;
			}
			if (password.length() == 0) {
				System.out.println("Error: Please include at least one character type.");
				return "";
			}
		}
		return password.toString();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of the password: ");
		int passwordLength = sc.nextInt();

		boolean[] charTypes = characterTypes(sc);

		String password = generatePassword(passwordLength, charTypes);

		System.out.println("Generated password is: " + password);
		sc.close();
	}
}
