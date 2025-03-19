package week_1;

import java.util.Scanner;

public class Calculator
{
	public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Console-Based Calculator");
        System.out.println("Select an operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter choice (1-4): ");

        int choice = scanner.nextInt();

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = 0;
        switch (choice) {
            case 1:
                result = calc.add(num1, num2);
                System.out.println("Result: " + result);
                break;
            case 2:
                result = calc.subtract(num1, num2);
                System.out.println("Result: " + result);
                break;
            case 3:
                result = calc.multiply(num1, num2);
                System.out.println("Result: " + result);
                break;
            case 4:
                result = calc.divide(num1, num2);
                System.out.println("Result: " + result);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid operation.");
        }
        scanner.close();
    }
}
