package task3.StudentGradeCalculator;

import java.util.Scanner;

public class StudentGradeCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of grades: ");
		int numOfGrades = sc.nextInt();

		double[] grades = new double[numOfGrades];
		double sum = 0;

		for (int i = 0; i < numOfGrades; i++) {
			System.out.print("Enter " + (i+1) +" grade:");
			grades[i] = sc.nextDouble();
			sum += grades[i];
		}

		double average = sum / numOfGrades;

		System.out.printf("The average of grades is: " + average);
		sc.close();
	}
}