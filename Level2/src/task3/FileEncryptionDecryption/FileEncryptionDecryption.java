package task3.FileEncryptionDecryption;

import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {

	private static final int SHIFT_KEY = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Choose an option:");
		System.out.println("1. Encrypt a file");
		System.out.println("2. Decrypt a file");
		System.out.print("Enter choice (1/2): ");
		int choice = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter the file path: ");
		String filePath = sc.nextLine();

		String outputFilePath = filePath + ((choice == 1) ? ".enc" : ".dec");
		if (choice == 1) {
			processFile(filePath, outputFilePath, SHIFT_KEY);
		} else if (choice == 2) {
			processFile(filePath, outputFilePath, -SHIFT_KEY);
		} else {
			System.out.println("Invalid choice! Please restart and select 1 or 2.");
		}

		sc.close();
	}

	private static void processFile(String inputFile, String outputFile, int shift) {
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(shiftText(line, shift));
				writer.newLine();
			}
			System.out.println("File encrypted successfully! Output: " + outputFile);
		} catch (IOException e) {
			System.out.println("Error processing the file: " + e.getMessage());
		}

	}

	private static String shiftText(String text, int shift) {
		StringBuilder result = new StringBuilder();
		for (char c : text.toCharArray()) {
			if (Character.isLetter(c)) {
				char base = Character.isUpperCase(c) ? 'A' : 'a';
				c = (char) (base + (c - base + shift + 26) % 26);
			}
			result.append(c);
		}
		return result.toString();
	}
}