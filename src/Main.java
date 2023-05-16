import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = 0.0;
        double num2 = 0.0;
        char operator;
        double result;

        boolean validNum1 = false;
        do {
            System.out.print("Enter the first number: ");
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
                validNum1 = true;
            } else {
                scanner.next(); // Clear the invalid input from the scanner buffer
                System.out.println("Error: Invalid number. Please try again.");
            }
        } while (!validNum1);

        boolean validOperator = false;
        do {
            System.out.print("Enter an operator (+, -, *, /): ");
            operator = scanner.next().charAt(0);

            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                validOperator = true;
            } else {
                System.out.println("Error: Invalid operator. Please try again.");
            }
        } while (!validOperator);

        boolean validNum2 = false;
        do {
            System.out.print("Enter the first number: ");
            if (scanner.hasNextDouble()) {
                num2 = scanner.nextDouble();
                validNum2 = true;
            } else {
                scanner.next();
                System.out.println("Error: Invalid number. Please try again.");
            }
        } while (!validNum2);

        switch (operator) {
            case '+':
                result = BasicOperators.add(num1, num2);
                System.out.println("Result: " + result);
                break;
            case '-':
                result = BasicOperators.subtract(num1, num2);
                System.out.println("Result: " + result);
                break;
            case '*':
                result = BasicOperators.multiply(num1, num2);
                System.out.println("Result: " + result);
                break;
            case '/':
                try {
                    result = BasicOperators.divide(num1, num2);
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Error: Invalid operator");
                break;
        }
    }
}
