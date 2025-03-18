package task1.TemperatureConverter;

import java.util.Scanner;

public class TemperatureConverter {

	public static double celsiusToFahrenheit(double celsius) {
		return (celsius * 1.8) + 32;
	}

	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter temperature value: ");
		double temp = sc.nextDouble();

		System.out.print("Enter temperature unit(C or F): ");
		char unit = sc.next().toUpperCase().charAt(0);

		if (unit == 'C') {
			System.out.println("Converted temperature is : " + celsiusToFahrenheit(temp) + "°F");
		} else if (unit == 'F') {
			System.out.println("Converted temperature is : " + fahrenheitToCelsius(temp) + "°C");
		} else {
			System.out.println("Invalid unit");
		}
		sc.close();
	}
}